package uam.azc.adsi.smartscheduler.clasesdao;

public class ExceptionDAO extends Exception {
    public ExceptionDAO(String string) {
        super(string);
    }

    public ExceptionDAO(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ExceptionDAO(Throwable thrwbl) {
        super(thrwbl);
    }
}
