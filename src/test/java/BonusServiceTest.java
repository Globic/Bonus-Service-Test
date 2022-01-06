import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateRegistredAndBonusUnderLimit() {

        BonusService service = new BonusService();
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegistredAndBonusOverLimit() {

        BonusService service = new BonusService();
        long amount = 1000_000_60;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegistredAndBonusUnderLimit() {

        BonusService service = new BonusService();
        long amount = 70_000;
        boolean registered = false;
        long expected = 7;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegistredAndBonusOverLimit() {

        BonusService service = new BonusService();
        long amount = 70_000_000;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
}