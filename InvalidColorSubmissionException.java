public class InvalidColorSubmissionException extends Exception {
    private UnoCard.Color diharapkan;
    private UnoCard.Color sebenarnya;

    public InvalidColorSubmissionException(String message, UnoCard.Color sebenarnya, UnoCard.Color diharapkan) {
        this.sebenarnya = sebenarnya;
        this.diharapkan = diharapkan;
    } 
}
