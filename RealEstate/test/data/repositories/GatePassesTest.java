package data.repositories;

import data.models.GatePass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GatePassesTest {
    private GatePasses gatePasses;

    @BeforeEach
    public void forAll(){
        gatePasses = new GatePasses();
    }

    @Test
    void testThatPassRepositoryIsEmpty() {
        int passTotal = gatePasses.count();
        Assertions.assertEquals(0,passTotal);

    }

    @Test
    void testThatWhenIAddANewPass_TotalIsOne() {
        int passTotal = gatePasses.count();
        Assertions.assertEquals(0,passTotal);

        GatePass gatepass = new GatePass();
        gatePasses.savePass(gatepass);
        passTotal = gatePasses.count();
        Assertions.assertEquals(1,passTotal);


    }

    @Test
    void thatWhenIDeleteAPass_ItReducesByNumberOfTimesDeleted() {
        int passTotal = gatePasses.count();
        Assertions.assertEquals(0,passTotal);

        GatePass gatepass = new GatePass();
        gatePasses.savePass(gatepass);
        gatePasses.savePass(gatepass);
        gatePasses.savePass(gatepass);
        gatePasses.savePass(gatepass);
        passTotal = gatePasses.count();
        gatePasses.delete(gatepass);
        gatePasses.delete(gatepass);
        passTotal = gatePasses.count();
        Assertions.assertEquals(2,passTotal);
    }

    @Test
    void testThatICanDeleteById() {
        int passTotal = get
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteByObject() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void count() {
    }
}