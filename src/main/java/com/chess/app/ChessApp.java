package com.chess.app;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class ChessApp extends Application {

    public static final int TILE_SIZE = 100;
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private Tile[][] board = new Tile[WIDTH][HEIGHT];

    private Group tileGroup = new Group();
    private Group pieceGroup = new Group();

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        root.getChildren().addAll(tileGroup, pieceGroup);

        for(int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                Tile tile = new Tile((x+y)%2==0, x, y);
                board[x][y] = tile;

                tileGroup.getChildren().add(tile);

                Piece piece = null;

                if ((x == 0 || x == 7) && y == 0) {
                    piece = makePiece(PieceType.bR, x, y);
                }
                else if((x == 1 || x == 6) && y == 0){
                    piece = makePiece(PieceType.bN, x, y);
                }
                else if((x == 2 || x == 5) && y == 0){
                    piece = makePiece(PieceType.bB, x, y);
                }
                else if((x == 3) && y == 0){
                    piece = makePiece(PieceType.bQ, x, y);
                }
                else if((x == 4) && y == 0){
                    piece = makePiece(PieceType.bK, x, y);
                }
                else if(y == 1){
                    piece = makePiece(PieceType.bP, x, y);
                }
                else if ((x == 0 || x == 7) && y == 7) {
                    piece = makePiece(PieceType.wR, x, y);
                }
                else if((x == 1 || x == 6) && y == 7){
                    piece = makePiece(PieceType.wN, x, y);
                }
                else if((x == 2 || x == 5) && y == 7){
                    piece = makePiece(PieceType.wB, x, y);
                }
                else if((x == 3) && y == 7){
                    piece = makePiece(PieceType.wQ, x, y);
                }
                else if((x == 4) && y == 7){
                    piece = makePiece(PieceType.wK, x, y);
                }
                else if(y == 6){
                    piece = makePiece(PieceType.wP, x, y);
                }

                if (piece != null) {
                    tile.setPiece(piece);
                    pieceGroup.getChildren().add(piece);
                }
            }
        }

        return root;
    }

    private Piece makePiece(PieceType type, int x, int y) {
        Piece piece = new Piece(type, x, y);

        piece.setOnMouseReleased(e -> {
            int newX = toBoard(piece.getLayoutX());
            int newY = toBoard(piece.getLayoutY());
            int oldX = toBoard(piece.getOldX());
            int oldY = toBoard(piece.getOldY());

            boolean isLegal = true;

            if(isLegal){
                if(board[newX][newY].getPiece() != null){
                    Piece otherPiece = board[newX][newY].getPiece();
                    System.out.println("capture!");
                    board[toBoard(otherPiece.getOldX())][toBoard(otherPiece.getOldY())].setPiece(null);
                    pieceGroup.getChildren().remove(otherPiece);
                }
                piece.move(newX, newY);
                board[oldX][oldY].setPiece(null);
                board[newX][newY].setPiece(piece);
            } else {
                piece.move(oldX, oldY);
            }

//            piece.move(newX, newY);
//            board[oldX][oldY].setPiece(null);
//            board[newX][newY].setPiece(piece);
//            System.out.println("moved");
        });

        return piece;
    }

    private int toBoard(double pixel) {
        return (int)(pixel + TILE_SIZE / 2) / TILE_SIZE;
    }

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Group root = new Group();
        Scene scene = new Scene(createContent());
        stage.setTitle("Chess");
        stage.setResizable(false);

        stage.setX(1000);
        stage.setY(50);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}