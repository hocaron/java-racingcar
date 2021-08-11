/*
 *   Class name : RacingCarPlayMain.java
 *   Version : 0.0.1
 *   Date : 2021/07/24
 */

package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.view.RacingCarResultView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 해당 메소드의 기능은 자동차 경주 게임을 시작합니다.
 * 자동차의 수와 , 이동하는 횟수를 입력받습니다.
 */
public class RacingCarPlayMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        RacingCarResultView view = new RacingCarResultView();

        String[] carNames = view.getCarNames(br);
        int moveCount = view.getMoveCount(br);

        RacingCar racingCar = new RacingCar(carNames, moveCount);
        List<Car> asCarsNumberOfEnteredByUser = racingCar.createAsCarsNumberOfEnteredByUser();

        view.drawRacingResult();
        for (int i = 0; i < moveCount; i++) {
            view.drawUI(racingCar.moveAsCarUserEntered(asCarsNumberOfEnteredByUser));
        }

        view.drawWinnerView(racingCar.getWinners(racingCar.getCars()));
    }
}