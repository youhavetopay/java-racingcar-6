package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class RacingView {

    private final RacingController controller = new RacingController();

    void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = readLine();

        if (!inputNames.contains(",")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        controller.setRacingCarName(inputNames);
    }
    
    void inputPlayCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = readLine();

        int playCount = convertStringToInt(input);

        controller.setRacingPlayCount(playCount);
    }

    void printPlayResult() {
        System.out.println("\n실행 결과");

        List<String> playResults = controller.getRacingPlayResults();

        for (String result : playResults) {
            System.out.println(result);
        }

        String winners = String.join(
                ",",
                controller.getWinners()
        );

        System.out.println("최종 우승자 : " + winners);
    }

    private int convertStringToInt(String input) {
        int number;

        try {
            number = Integer.parseInt(input);

        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return number;
    }

}
