package com.chess.app;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import static com.chess.app.ChessApp.TILE_SIZE;

public class Piece extends StackPane {
    private PieceType type;

    private double mouseX, mouseY, oldX, oldY;

    public PieceType getType() {
        return type;
    }

    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }

    public Piece(PieceType type, int x, int y) {
        this.type = type;

        move(x, y);

//        Ellipse bg = new Ellipse(TILE_SIZE * 0.3125, TILE_SIZE * 0.26);
//        bg.setFill(Color.BLACK);
//
//        bg.setStroke(Color.BLACK);
//        bg.setStrokeWidth(TILE_SIZE * 0.03);
//
//        bg.setTranslateX((TILE_SIZE - TILE_SIZE * 0.3125 * 2) / 2);
//        bg.setTranslateY((TILE_SIZE - TILE_SIZE * 0.26 * 2) / 2 + TILE_SIZE * 0.07);
//
//        Ellipse ellipse = new Ellipse(TILE_SIZE * 0.3125, TILE_SIZE * 0.26);
//        ellipse.setFill(type == PieceType.bB
//                ? Color.valueOf("#c40003") : Color.valueOf("#fff9f4"));
//
//        ellipse.setStroke(Color.BLACK);
//        ellipse.setStrokeWidth(TILE_SIZE * 0.03);
//
//        ellipse.setTranslateX((TILE_SIZE - TILE_SIZE * 0.3125 * 2) / 2);
//        ellipse.setTranslateY((TILE_SIZE - TILE_SIZE * 0.26 * 2) / 2);
//
//        getChildren().addAll(bg, ellipse);

        Image image = new Image(type.pieceImagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(TILE_SIZE);
        imageView.setFitWidth(TILE_SIZE);
//        imageView.setTranslateX((TILE_SIZE - TILE_SIZE * 0.1 * 2) / 2);
//        imageView.setTranslateY((TILE_SIZE - TILE_SIZE * 0.1 * 2) / 2);
        getChildren().add(imageView);


    }

    public void move(int x, int y) {
        oldX = x * TILE_SIZE;
        oldY = y * TILE_SIZE;
        relocate(oldX, oldY);
    }
}
