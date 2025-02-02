package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingInitParticipantsTest {

    private static Racing racing;

    @BeforeEach
    void init() {
        racing = new Racing();
    }

    @Test
    @DisplayName("initParticipants 이름 길이 초과 실패 테스트")
    void initParticipants_name_length_over_fail() {

        String[] carNames = {"디카프리오", "레옹", "인텔리제이짱짱맨"};

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racing.initParticipants(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("initParticipants 이름 길이 부족 실패 테스트")
    void initParticipants_name_length_lack_fail() {

        String[] carNames = {"", "레옹", "인텔리제이"};

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racing.initParticipants(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("initParticipants 이름 중복 실패 테스트")
    void initParticipants_name_duplication_fail() {

        String[] carNames = {"디카프리오", "디카프리오", "레옹"};

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racing.initParticipants(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("initParticipants 참여자 초과 실패 테스트")
    void initParticipants_participants_over_fail() {

        String[] carNames = {"디카프리오", "레옹", "마틸다", "로즈", "고든", "레이첼"};

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racing.initParticipants(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("initParticipants 검증 테스트")
    void initParticipants_validate() {

        String[] carNames = {"디", "레옹", "마틸다", "로즈", "고든"};

        racing.initParticipants(carNames);

        assertThat(racing.getCarNames()).contains("디", "레옹", "마틸다", "로즈", "고든");

        List<Car> result = racing.getParticipants();

        for (int i = 0; i < result.size(); i++) {
            Car car = result.get(i);
            assertThat(car.toString()).contains(carNames[i]);
        }
    }

}
