package testTasks.deleteECHD;

public class Main {
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTTVU4VVFSajlkajFFQXlLWWFFSUJqZGladlVRYms2dmdQRFZrdzE3dU9BcE1KSE83Yyt2QTdNdzZNM3ZzTmVZcUxTZ2dLZ2tKclNYXC9SQnRcL2dOR0NscHJXYjVhRFBXMklVMjNldkgzdmZkK2Jrek9ZMEFxZXhvb3dycjJVWnpFVG5rNFZFN0dtWWFhWUdYaVpwaXFpcG1DOExJZ2RST0RpT0M0NFByZ3NNbkRQM3laOVV1VkV4TldndTAxRFU4c1ZQSkVxSGluMkZFbm9ybFE3M3BWMktCWDl5NkNVZHI2Nk1Ma0pjeVFNWlNiTW1oU05QR1dLUnBzd1cySytESGNzZERcL0VHeW9NSTF5UFV5ZXBJRjFPSXgrbVNHYmVTblJsVkJ1NGV4RTJNNHhYMjlUVWZMaVZFcTB4M1QrVHRJMk5idTl0VElFVHZJUDNVTWxUQndcL3U3cEdsZWxiSHEwdk9jV29taFY3cWlFUkdyTWVzT2VvUEZ6NzkyRDhlZGx3QTNNbmo2XC84cDhma1ZHSDU3Yzc1WUxOb0pEVHdZaTE3U2FubUthZVpLNVhWRnJmUFBvK2JudzdPUHIyK2dzMlc4K1A4K2xwWkhteHZVWlpJU1JZd2M2d2hsZHl2NDdhTDR5dlhpbHkwTXZEWkxVazd4UlFsRG95dUxVaGpIclNqSkxcL2R0NEhZcjhCdGJqZnFyNTlwaU13YnVGRWpRYkxTVzE0TldibUI2bzB1QzFWN2VET3E5WndadTlwbmVvaEVtbXlrV1l4djFmSWw5N3AwZWZOOVwvK0F0ZFZtR2lUM2hHc1pmWmtyU1dKVjJxUHB3Y0xreDkrYjFYVERsNjhZdFwvQU1SYWxRWTFBd0FBIiwic3ViIjoidmlzX2VkIiwicm9sZXMiOlsiUk9MRV9FQ0hEIiwiUk9MRV9PUEVSQVRPUiJdLCJpc3MiOiJTcHJpbmcgU2VjdXJpdHkgUkVTVCBHcmFpbHMgUGx1Z2luIiwiZXhwIjoxNjg5OTUxNjM2LCJpYXQiOjE2ODk4NjUyMzZ9.QJCFoG-GBY-jteb_RHTkBKW35wU2By9vUMWdM_GyRMs";
        Parser parser = new Parser();
        Builder builder = new Builder();
        builder.build(parser.parseCsv("C:\\Users\\savoo\\OneDrive\\������� ����\\34.csv")
                , "C:\\Users\\savoo\\OneDrive\\������� ����\\res.csv", token);
    }
}
