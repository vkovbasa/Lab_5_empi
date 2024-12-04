import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int N = 5; // Номер студента
        int size = 5 * N;

        // Генерація нормального розподілу
        double[] data = generateNormalDistribution(size, 0, N);

        // Обчислення статистичних параметрів
        double mean = calculateMean(data);
        double variance = calculateVariance(data, mean);
        double stdDeviation = Math.sqrt(variance);
        double skewness = calculateSkewness(data, mean, stdDeviation);
        double kurtosis = calculateKurtosis(data, mean, stdDeviation);

        // Виведення результатів
        System.out.println("Середнє (Mean): " + mean);
        System.out.println("Дисперсія (Variance): " + variance);
        System.out.println("Середнє квадратичне відхилення (Standard Deviation): " + stdDeviation);
        System.out.println("Коефіцієнт асиметрії (Skewness): " + skewness);
        System.out.println("Коефіцієнт ексцесу (Kurtosis): " + kurtosis);
    }

    // Генерація даних нормального розподілу
    private static double[] generateNormalDistribution(int size, double mean, double range) {
        Random random = new Random();
        double[] data = new double[size];
        for (int i = 0; i < size; i++) {
            double value = random.nextGaussian() * (range / 3.0) + mean;
            data[i] = Math.min(Math.max(value, 0), range);
        }
        return data;
    }

    // Обчислення середнього значення
    private static double calculateMean(double[] data) {
        double sum = 0;
        for (double value : data) {
            sum += value;
        }
        return sum / data.length;
    }

    // Обчислення дисперсії
    private static double calculateVariance(double[] data, double mean) {
        double sum = 0;
        for (double value : data) {
            sum += Math.pow(value - mean, 2);
        }
        return sum / data.length;
    }

    // Обчислення коефіцієнта асиметрії
    private static double calculateSkewness(double[] data, double mean, double stdDeviation) {
        double sum = 0;
        for (double value : data) {
            sum += Math.pow((value - mean) / stdDeviation, 3);
        }
        return sum / data.length;
    }

    // Обчислення коефіцієнта ексцесу
    private static double calculateKurtosis(double[] data, double mean, double stdDeviation) {
        double sum = 0;
        for (double value : data) {
            sum += Math.pow((value - mean) / stdDeviation, 4);
        }
        return (sum / data.length) - 3; // Віднімаємо 3 для excess kurtosis
    }
}
