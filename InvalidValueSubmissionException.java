public class InvalidValueSubmissionException extends Exception {
    private UnoCard.Value diharapkan;
    private UnoCard.Value sebenarnya;

    public InvalidColorSubmissionException(String message, UnoCard.Value sebenarnya, UnoCard.Value diharapkan) {
        this.sebenarnya = sebenarnya;
        this.diharapkan = diharapkan;
    } 
}
