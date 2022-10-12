public class Converter {
    /*
      Количество сожжённых килокалорий;
      Для подсчёта дистанции можно считать, что один шаг равен 75 см. 1 step = 0.00075 km
      Для подсчёта количества сожжённых килокалорий можно считать, что 1 шаг = 50 калорий,
                                                                      1 килокалория = 1 000 калорий.*/
    public double showDistance(double totalAmt) { //пройденная дистанция

        double distance = totalAmt * 0.00075;
        return distance;
    }

    public double showCalAmt(double totalAmt) { //Количество сожжённых килокалорий;
        double calAmt = (totalAmt * 50)/1000;
        return calAmt;
    }
}
