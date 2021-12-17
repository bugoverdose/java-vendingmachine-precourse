package constants;

public class ExceptionMessages {

    private static final String ERROR = "[ERROR] ";
    public static String NOT_INT_TYPE_EXCEPTION = ERROR + "금액은 숫자여야 합니다.";
    public static String NEGATIVE_INT_EXCEPTION = ERROR + "금액은 음수일 수 없습니다.";
    public static String ONE_WON_EXCEPTION = ERROR + "금액으로 1원 단위를 입력할 수 없습니다.";

    public static String DUPLICATE_PRODUCT_NAME_EXCEPTION = ERROR + "중복된 상품명입니다.";
    public static String MINIMUM_PRICE_EXCEPTION = ERROR + "상품의 가격은 100원 이상이어야 합니다.";
    public static String STOCK_NOT_INT_TYPE_EXCEPTION = ERROR + "재고는 숫자여야 합니다.";
    public static String STOCK_NEGATIVE_INT_EXCEPTION = ERROR + "재고는 음수일 수 없습니다.";

    public static String NOT_EXISTING_PRODUCT_EXCEPTION = ERROR + "존재하지 않는 상품입니다.";
    public static String NOT_ENOUGH_MONEY_EXCEPTION = ERROR + "잔액이 충분하지 않습니다.";
    public static String NO_STOCK_EXCEPTION = ERROR + "재고가 부족합니다.";
}
