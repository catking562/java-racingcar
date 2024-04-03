package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.game.Game;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        try{
            game.startGame();
            game.endGame();
        }catch(Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }
}
