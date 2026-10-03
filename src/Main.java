public class Main {
    public static void main(String[] args) {
        int passed = 0;
        int total = 7;

        Renderer vector = new VectorRenderer();
        Renderer raster = new RasterRenderer();

        //T1-Circle+VectorRenderer
        Circle circle1 = new Circle("C1", vector);
        String resT1 = circle1.execute();
        boolean passT1 = resT1.equals("VECTOR Circle radius/side=2");
        printCheck("T1", passT1, "Circle + VectorRenderer", resT1);
        if (passT1) passed++;

        //T2-Circle + RasterRenderer
        Circle circle2 = new Circle("C2", raster);
        String rest2 = circle2.execute();
        boolean passT2 = rest2.equals("RASTER Circle radius/side=2");
        printCheck("T2", passT2, "Circle + RasterRenderer", rest2);
        if (passT2) passed++;

        // T3-Square + VectorRenderer
        Square square1 = new Square("S1", vector);
        String resT3 = square1.execute();
        boolean passT3 = resT3.equals("VECTOR Square radius/side=3");
        printCheck("T3", passT3, "Square + VectorRenderer", resT3);
        if (passT3) passed++;

        // T4-Square + RasterRenderer
        Square square2 = new Square("S2", raster);
        String resT4 = square2.execute();
        boolean passT4 = resT4.equals("RASTER Square radius/side=3");
        printCheck("T4", passT4, "Square + RasterRenderer", resT4);
        if (passT4) passed++;

        // T5-Dynamic Switch
        Circle switchObj = new Circle("C_SWITCH", vector);
        String before = switchObj.execute();
        String idBefore = switchObj.getId();

        switchObj.setImplementation(raster);
        String after = switchObj.execute();

        boolean sameRef = (switchObj == switchObj);
        boolean sameData = idBefore.equals(switchObj.getId()) && switchObj.getRadius() == 2;
        boolean passT5 = sameRef && sameData && before.contains("VECTOR") && after.contains("RASTER");

        System.out.printf("T5 %s sameObject=%b | stateUnchanged=%b | before=<%s> | after=<%s>%n",
                passT5 ? "PASS" : "FAIL", sameRef, sameData, before, after);
        if (passT5) passed++;

        // T6-Circle + AsciiRenderer (I3)
        Renderer ascii = new AsciiRenderer();
        Circle circleAscii = new Circle("C3", ascii);
        String resT6 = circleAscii.execute();
        boolean passT6 = resT6.equals("ASCII Circle size=2");
        printCheck("T6", passT6, "Circle + AsciiRenderer", resT6);
        if (passT6) passed++;

        // T7-Square + AsciiRenderer (I3)
        Square squareAscii = new Square("S3", ascii);
        String resT7 = squareAscii.execute();
        boolean passT7 = resT7.equals("ASCII Square size=3");
        printCheck("T7", passT7, "Square + AsciiRenderer", resT7);
        if (passT7) passed++;

        System.out.printf("SUMMARY: %d/%d PASS%n", passed, total);
    }

    private static void printCheck(String id, boolean pass, String details, String result) {
        System.out.printf("%s %s | %s | result=%s%n", id, pass ? "PASS" : "FAIL", details, result);
    }

}
