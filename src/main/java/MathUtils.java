import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MathUtils {
    public static double getHarmonicMean(Collection<Double> numbers) {
        double n = numbers.size();
        double temp = 0.;
        for (Double aDouble : numbers) {
            temp += 1. / aDouble;
        }
        return n / temp;
    }

    public static double getGeometricMean(Collection<Double> numbers) {
        double n = numbers.size();
        double temp = 1.;
        for (Double aDouble : numbers) {
            temp *= aDouble;
        }
        return Math.pow(temp, 1. / n);
    }

    public static double getGeometricMean2(Collection<Double> numbers) {
        double n = numbers.size();
        double temp = 1.;
        for (Double aDouble : numbers) {
            temp *= Math.pow(aDouble, 1. / n);
        }
        return temp;
    }


    public static double getArithmaticMean(Collection<Double> numbers) {
        double n = numbers.size();
        double temp = 0.;
        for (Double aDouble : numbers) {
            temp += aDouble;
        }
        return temp / n;
    }


    public static double getQuadraticMean(Collection<Double> numbers) {
        double n = numbers.size();
        double temp = 0.;
        for (Double aDouble : numbers) {
            temp += aDouble * aDouble;
        }
        return Math.sqrt(temp / n);

    }

    public static void main(String[] args) {
        Date last = new Date();

        Random random = new Random();
        int randomCnt = 10000;
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < randomCnt; i++) {
            list.add(random.nextInt(100) + 1.);
        }
        System.out.println(new Date().getTime() - last.getTime());
        System.out.println();
        last = new Date();

        System.out.println(getHarmonicMean(list));
        System.out.println(new Date().getTime() - last.getTime());
        System.out.println();
        last = new Date();

        System.out.println(getGeometricMean2(list));
        System.out.println(new Date().getTime() - last.getTime());
        System.out.println();
        last = new Date();

        System.out.println(getArithmaticMean(list));
        System.out.println(new Date().getTime() - last.getTime());
        System.out.println();
        last = new Date();

        System.out.println(getQuadraticMean(list));
        System.out.println(new Date().getTime() - last.getTime());
        System.out.println();
        last = new Date();

        System.out.println(list.size());
    }

}
