package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void 로또_구입_금액은_1000으로_나누어_떨어져야_한다() {
        assertDoesNotThrow(() -> new User("2000"));
    }

    @Test
    void 로또_구입_금액이_1000원으로_나누어_떨어지지_않으면_에러() {
        assertThatThrownBy(() ->
                new User("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_금액은_숫자만_입력받을_수_있다() {
        assertDoesNotThrow(() -> new User("14000"));
    }

    @Test
    void 로또_구입_금액이_숫자가_아니면_에러() {
        assertThatThrownBy(() ->
                new User("1000i"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_금액으로_로또_개수를_계산한다() {
        User user = new User("14000");
        assertThat(user.getLottoCount()).isEqualTo(14);
    }
}