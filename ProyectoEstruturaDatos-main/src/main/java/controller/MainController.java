package controller;

import com.espol.proyectoestruturadatos.model.board.Symbol;

/**
 * Controlador principal de la aplicación.
 * Orquesta la comunicación entre los sub-controladores del juego.
 * 
 * @author Gabriel
 */
public class MainController {

    private ChooseController chooseController;
    private BoardController boardController;

    public MainController() {
        this.chooseController = new ChooseController();
    }

    public void startNewGame(boolean isHumanX, boolean humanStarts) {
        chooseController.setPreferences(isHumanX, humanStarts);
        boardController = new BoardController(
            chooseController.getHumanSymbol(),
            chooseController.getBotSymbol(),
            chooseController.isHumanStarts()
        );
    }

    public ChooseController getChooseController() {
        return chooseController;
    }

    public BoardController getBoardController() {
        return boardController;
    }

    public void setBoardController(BoardController boardController) {
        this.boardController = boardController;
    }

    public String getFinalResultMessage() {
        if (boardController == null) return "";
        return ResultController.getResultMessage(boardController.getWinner(), chooseController.getHumanSymbol());
    }

    public String getFinalResultTitle() {
        if (boardController == null) return "";
        return ResultController.getResultTitle(boardController.getWinner(), chooseController.getHumanSymbol());
    }
}
