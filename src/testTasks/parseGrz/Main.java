package testTasks.parseGrz;

import testTasks.parseGrz.builder.BuilderGrz;
import testTasks.parseGrz.model.Grz_FIZ;
import testTasks.parseGrz.model.Grz_UO;
import testTasks.parseGrz.parser.ParserImpl;

public class Main {
    public static void main(String[] args) {
        boolean uo = true;
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJrX3dFVWZJdEpQWEFNM1VvckVnd29aYV9LN21yOXZsSkNtdjJlYUl1Y19RIn0.eyJleHAiOjE2ODk3NzgxMzMsImlhdCI6MTY4OTc3NzgzMywianRpIjoiZWMxZGQxODEtOTMwYi00NzMzLWExYzEtOGIyMzU1ZjgyMWI2IiwiaXNzIjoiaHR0cHM6Ly9pZC5kb20ucnUvcmVhbG1zL2xrIiwic3ViIjoiN2I2NGYwMmEtYWExOC00MGQwLWIyOWMtYzYyMzY5Mzc0YTQ3IiwidHlwIjoiQmVhcmVyIiwiYXpwIjoicHVibGljLWRpdG0tY2xpZW50Iiwic2NvcGUiOiJkZXZpY2VzIiwiY29tcGFueUlkIjoiNjJhOTA2NmYxZWI1M2MyZTA1NGU5YTdjIiwiY2xpZW50SG9zdCI6IjkxLjE5MS4xODMuNDEiLCJjbGllbnRJZCI6InB1YmxpYy1kaXRtLWNsaWVudCIsImNsaWVudEFkZHJlc3MiOiI5MS4xOTEuMTgzLjQxIn0.JfD6Mc1V_9FTpsJIsxqU7OenknH_QwxELyOhaB7LWqpMHaF04Dap6vnnWpP0EdAHWSynfeQ-3sxeZOeLN-s57JySvovlroIKN78Pxztc710wpp0QWxBb5o-z0xpJwReFqzF2zMe4xdaOUuZdlvo6bBV7ql1oZLoO2k5-Gi8LJ5OU1TLcFKK3uDzd9_dm4yV7NtMmhy-qrUoeyZjGlKFt5jWsMKUGfmetn0NsvLELMDgTtzD17ZEhaSwEYa1ghyjpje-AdOG9ULTKgOkfq3ZYLlnnSVIkGOryew6vef5gLD7f8NGVm5CEuScUSo9C_N2Nhaqr9toL1v1ld0MCOtKGeA";
        String tokenUjin = "cDD17b5c740EE351Cc1DCFa111B979AAA5BEbBff8FaDc6f4dEfE218daBCCfc82f8fB1BB4E52880f154dEEB1a7ef23aF8cf78";
        //CsvParser parser = new CsvParser();
        ParserImpl parser = new ParserImpl(uo ? Grz_UO.class : Grz_FIZ.class);

        BuilderGrz builder = new BuilderGrz();
        builder.build(parser.parseCsv("C:\\Users\\savoo\\OneDrive\\Рабочий стол\\data-1689776691268.csv"), token, tokenUjin, "C:\\Users\\savoo\\OneDrive\\Рабочий стол\\Result.csv", uo);
        //CsvBuilder builder = new CsvBuilder();
        //builder.buildUO(grzUos, token, );
    }
}
