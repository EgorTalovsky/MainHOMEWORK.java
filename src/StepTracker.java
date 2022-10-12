public class StepTracker {
    MonthData[] monthToData;

    int stepsGoal = 10000;
    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {
        int[] dates = new int[30];
    }

    public void saveSteps(int s, int m, int d) {                                                // сохранение шагов
        monthToData[m].dates[d] += s;                                                           // добавлена возможность довнести шаги
    }

    public void showDailyStats(int m) {                                                          //Количество пройденных шагов по дням в следующем формате: 1 день: 3000, 2 день: 2000, ..., 30 день: 10000
        for (int i = 0; i < monthToData[m].dates.length; i++) {
            System.out.print(i + " день: " + monthToData[m].dates[i] + ", ");
        }
        System.out.println();
    }

    public int showTotalAmt (int m) {                                                            //Общее количество шагов за месяц;
        int sum = 0;
        for (int i = 0; i < monthToData[m].dates.length; i++) {
            sum += monthToData[m].dates[i];
        }
        return sum;
    }

    public int showMaxAmt (int m) {                                                             // Максимальное пройденное количество шагов в месяце;
        int max = 0;
        for (int i = 0; i < monthToData[m].dates.length; i++) {
            if (monthToData[m].dates[i] > max) {
                max = monthToData[m].dates[i];
            }
        }
        return max;
    }

    public double showAvrgAmt (int m) {                                                         //Среднее количество шагов;
        double avrg = showMaxAmt(m)/monthToData[m].dates.length;
        return avrg;
    }

    public int bestRange (int m) {                                                              //  Лучшая серия
        int a = 0;
        int b = 0;
        for (int i = 0; i < monthToData[m].dates.length; i++) {
            if (monthToData[m].dates[i] >= stepsGoal) {
                a++;
            } else {
                if (a > b) {
                    b = a;
                }
                a = 0;
            }
        }
        return b;
    }

    public void saveNewGoal (int g) {                                                           // сохранение лучшей цели
        stepsGoal = g;
    }
}




