package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Game {

    CarData[] cardatas;
    int count = 0;
    BufferedWriter writer;

    public Game() {
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void flushOutput(String string) throws Exception {
        writer.write(string);
        writer.flush();
    }

    public int toInt(String string) {
        try{
            return Integer.parseInt(string);
        }catch(Exception e) {
            return -1;
        }
    }

    public void inputCars() throws Exception {
        flushOutput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String[] cars = Console.readLine().split(",");
        cardatas = new CarData[cars.length];
        for(int i = 0; i<cars.length; i++) {
            if(cars[i].length()>5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
            }
            cardatas[i] = new CarData(cars[i]);
        }
    }

    public void inputCount() throws Exception {
        flushOutput("시도할 회수는 몇회인가요?\n");
        count = toInt(Console.readLine());
        if(count<1) {
            throw new IllegalArgumentException("1이상의 정수를 입력해주세요. 입력해주세요.");
        }
    }

    public void updateCars() throws Exception {
        for(CarData cd : cardatas) {
            cd.update();
            StringBuilder sb = new StringBuilder(cd.getName()+" : ");
            for(int k = 0; k<cd.getRunCount(); k++) {
                sb.append("-");
            }
            sb.append("\n");
            flushOutput(sb.toString());
        }
    }

    public void outputWinner() throws Exception {
        int maxcount = 0;
        ArrayList<CarData> winner = new ArrayList<>(cardatas.length);
        for(CarData cd : cardatas) {
            if(cd.getRunCount()==maxcount) {
                winner.add(cd);
            }else if(cd.getRunCount()>maxcount) {
                maxcount = cd.getRunCount();
                winner.clear();
                winner.add(cd);
            }
        }
        StringBuilder mes = new StringBuilder("최종 우승자 : ");
        for(int j = 0; j<winner.size()-1; j++) {
            mes.append(winner.get(j).getName()).append(", ");
        }
        mes.append(winner.get(winner.size()-1).getName());
        flushOutput(mes.toString());
    }

    public void startGame() throws Exception {
        inputCars();
        inputCount();
        flushOutput("\n실행 결과\n");
        for(int j = 0; j<count; j++) {
            updateCars();
            flushOutput("\n");
        }
        outputWinner();
    }

    public void endGame() throws Exception {
        writer.close();
    }
}
