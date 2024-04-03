package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;

public class CarData {

    private final String name;
    private int runcount = 0;

    public CarData(String name) {
        this.name = name;
    }

    public void update() {
        if( Randoms.pickNumberInRange(0,9)>3) {
            addCount();
        }
    }

    public String getName() {
        return name;
    }

    public int getRunCount() {
        return runcount;
    }

    public void addCount() {
        runcount++; //을 실행합니다.
    }

}
