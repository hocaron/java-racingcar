package study.step3;

import java.util.Random;
import java.util.Scanner;

public class JavaRacingcarSimple {

	private static final int STANDARD = 4;
	private static final Scanner SCANNER = new Scanner(System.in);

	public void printJavaRacingcarSimple() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		int number = SCANNER.nextInt();

		System.out.println("시도할 회수는 몇 회 인가요?");
		int count = SCANNER.nextInt();

		Racingcar[] racingcars = initRacingCars(number);

		System.out.println("실행 결과");
		for (int i = 0; i < count; i++) {
			proceedJavaRacingcarsSimple(racingcars);
			System.out.println();
		}

		SCANNER.close();
	}

	// Racingcar class 초기화
	public Racingcar[] initRacingCars(int number) {
		Racingcar[] racingcars = new Racingcar[number];
		for (int i = 0; i < number; i++) {
			racingcars[i] = initRacingCar();
		}
		return racingcars;
	}

	// Racingcar class 초기화
	public Racingcar initRacingCar() {
		Racingcar racingcar = new Racingcar();
		racingcar.initPosition();
		return racingcar;
	}

	// 초간단 자동차 경주 게임 진행
	public void proceedJavaRacingcarsSimple(Racingcar[] racingcars) {
		for (int i = 0; i < racingcars.length; i++) {
			proceedJavaRacingcarSimple(racingcars[i]);
			printCurrentStatus(racingcars[i].getPosition());
		}
	}

	// 초간단 자동차 경주 게임 진행
	public void proceedJavaRacingcarSimple(Racingcar racingcar) {
		if (isGoForward(new Random().nextInt(10))) {
			racingcar.move();
		}
	}

	// random 값이 4이상인 경우 true 반환
	public boolean isGoForward(int random) {
		return random >= STANDARD;
	}

	// score 개수 만큼 "-" 출력
	public void printCurrentStatus(int position) {
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
