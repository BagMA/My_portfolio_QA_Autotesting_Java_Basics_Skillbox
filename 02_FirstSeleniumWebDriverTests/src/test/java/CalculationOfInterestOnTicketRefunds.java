import org.junit.Assert;
import org.junit.Test;

public class CalculationOfInterestOnTicketRefunds {

    /*
    В случае отказа от посещения мероприятия по причинам, не связанным с отменой/переносом мероприятия, посетитель имеет право при возврате билета:
    1) более 10 дней - получить обратно полную стоимость билетов;
    2) от 6 до 10 дней включительно - получить только 50% стоимости билетов;
    3) от 3 до 6 дней включительно - получить 30% стоимости билетов;
    4) 72 часа и менее до начала концерта - стоимость билетов не возвращается.
     */
    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled)
    {
        if(wasConcertCancelled && wasConcertRescheduled) return 100;
        if(hoursBeforeConcert > 240) return 100;
        if(hoursBeforeConcert >= 144 && hoursBeforeConcert <= 240) return 50;
        if(hoursBeforeConcert > 3 && hoursBeforeConcert <= 144) return 30;
        return 0;
    }

    private void limitValueCheck(int hoursBeforeConcert, int expectedRes, Boolean wasConcertCancelled, Boolean wasConcertRescheduled) {
        int actualRes = getRefundTicketPricePercent(hoursBeforeConcert, wasConcertCancelled, wasConcertRescheduled);
        Assert.assertEquals(expectedRes, actualRes);
    }

    @Test
    public void test1() {
        limitValueCheck(100, 100, true, true);
    }

    @Test
    public void test2() {
        limitValueCheck(241, 100, true, false);
    }
    @Test
    public void test3() {
        limitValueCheck(240, 50, false, true);
    }
    @Test
    public void test4() {
        limitValueCheck(239, 50, false, false);
    }
    @Test
    public void test5() {
        limitValueCheck(145, 50, false, false);
    }
    @Test
    public void test6() {
        limitValueCheck(144, 50, false, false);
    }
    @Test
    public void test7() {
        limitValueCheck(143, 30, false, false);
    }
    @Test
    public void test8() {
        limitValueCheck(4, 30, false, false);
    }
    @Test
    public void test9() {
        limitValueCheck(3, 0, false, false);
    }
    @Test
    public void test10() {
        limitValueCheck(2, 0, false, false);
    }
}


