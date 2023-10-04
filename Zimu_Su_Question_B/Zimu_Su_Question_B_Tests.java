package Zimu_Su_Question_B;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class Zimu_Su_Question_B_Tests {
    @Test
    public void first_version_greater_same_length() {
        String v1 = "1.0.1";
        String v2 = "1.0.0";

        assertEquals(-1, Zimu_Su_Question_B.compareVersion(v1, v2));
    }

    @Test
    public void second_version_greater_same_length() {
        String v1 = "1.0.0";
        String v2 = "1.0.1";

        assertEquals(1, Zimu_Su_Question_B.compareVersion(v1, v2));
    }

    @Test
    public void versions_equal_same_length() {
        String v1 = "1.0.1";
        String v2 = "1.0.1";

        assertEquals(0, Zimu_Su_Question_B.compareVersion(v1, v2));
    }

    @Test
    public void first_version_greater_diff_length() {
        String v1 = "1.0.1";
        String v2 = "1.0";

        assertEquals(-1, Zimu_Su_Question_B.compareVersion(v1, v2));
    }

    @Test
    public void second_version_greater_diff_length() {
        String v1 = "1.0";
        String v2 = "1.0.1";

        assertEquals(1, Zimu_Su_Question_B.compareVersion(v1, v2));
    }

    @Test
    public void versions_equal_diff_length() {
        String v1 = "1.0.1";
        String v2 = "1.0.1.0.0";

        assertEquals(0, Zimu_Su_Question_B.compareVersion(v1, v2));
    }
}
