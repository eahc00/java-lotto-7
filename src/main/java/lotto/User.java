package lotto;

public class User {

    private final long ONE_LOTTO_FEE = 1000;
    private final long money;
    private final long lottoCount;

    public User(String userMoney) throws IllegalArgumentException {
        validateUserMoney(userMoney);
        this.money = Long.parseLong(userMoney);
        this.lottoCount = money / ONE_LOTTO_FEE;
    }

    private static void validateUserMoney(String userMoneyInput) throws IllegalArgumentException {
        if (!(userMoneyInput.chars().allMatch(Character::isDigit))) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자로만 입력해야 합니다.");
        }
        if (Long.parseLong(userMoneyInput) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public long getLottoCount() {
        return lottoCount;
    }
}