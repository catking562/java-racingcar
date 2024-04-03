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

    public int toInt(String string) {
        try{
            return Integer.parseInt(string);
        }catch(Exception e) {
            return -1;
        }
    }

    public void InputCars() throws Exception {
        writer.write("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        writer.flush();
        String[] cars = Console.readLine().split(",");
        cardatas = new CarData[cars.length];
        for(int i = 0; i<cars.length; i++) {
            if(cars[i].length()>5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
            }
            cardatas[i] = new CarData(cars[i]);
        }
    }

    public void InputCount() throws Exception {
        writer.write("시도할 회수는 몇회인가요?\n");
        writer.flush();
        count = toInt(Console.readLine());
        if(count<1) {
            throw new IllegalArgumentException("1이상의 정수를 입력해주세요. 입력해주세요.");
        }
    }

    public void UpdateCars() throws Exception {
        for(CarData cd : cardatas) {
            cd.Update();
            //자동차 진행상황 출력
            StringBuilder sb = new StringBuilder(cd.getName()+" : ");
            for(int k = 0; k<cd.getRunCount(); k++) {
                sb.append("-");
            }
            sb.append("\n");
            writer.write(sb.toString());
            writer.flush();
        }
    }

    public void OutputWinner() {
        int maxcount = 0;
        ArrayList<CarData> winner = new ArrayList<>();
        for(CarData cd : cardatas) {
            if(cd.getRunCount()==maxcount) {
                winner.add(cd);
            }else if(cd.getRunCount()>maxcount) {
                maxcount = cd.getRunCount();
                winner.clear();
                winner.add(cd);
            }
        }
        //출력
        StringBuilder mes = new StringBuilder("최종 우승자 : ");
        for(int j = 0; j<winner.size()-1; j++) {
            mes.append(winner.get(j).getName()).append(", ");
        }
        mes.append(winner.get(winner.size()-1).getName());
        System.out.println(mes.toString());
    }

    public void StartGame() throws Exception {
        InputCars(); //자동차 입력
        InputCount(); //실행횟수 입력

        writer.write("\n실행 결과\n");
        writer.flush();

        for(int j = 0; j<count; j++) { //입력한 수만큼 반복
            UpdateCars(); //자동차들을 모두 업데이트
            writer.write("\n");
            writer.flush(); //줄넘김
        }

        OutputWinner(); //우승자 출력
    }

    public void EndGame() throws Exception {
        writer.close();
    }
}
