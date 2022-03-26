import java.util.function.*;


class Operator {

    public static LongBinaryOperator binaryOperator = (long x, long y) -> {
        if(x == 0){
            return 0;
        }
        if(x == y){
            return y;
        }
        long product = 1;
        for(long i = x; i <= y ; i++ ){
            product *= i;
        }
        return product;
    };
}