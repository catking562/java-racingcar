package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;

public class CarData {

    public String name;
    public int runcount = 0;

    public CarData(String name) {
        this.name = name;
    }

    public void Update() {
        if( Randoms.pickNumberInRange(0,9)>3) {
            addCount();
        }
    }

    public void addCount() {
        runcount++; //을 실행합니다.
    }

}
