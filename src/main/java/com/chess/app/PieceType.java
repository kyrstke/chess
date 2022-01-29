package com.chess.app;

public enum PieceType {
    bK("file:/home/bambo/Documents/studia/sieci/SK2-chess-java/src/bK.png"),
    bQ ("file:/home/bambo/Documents/studia/sieci/SK2-chess-java/src/bQ.png"),
    bB("file:/home/bambo/Documents/studia/sieci/SK2-chess-java/src/bB.png"),
    bN("file:/home/bambo/Documents/studia/sieci/SK2-chess-java/src/bN.png"),
    bR("file:/home/bambo/Documents/studia/sieci/SK2-chess-java/src/bR.png"),
    bP("file:/home/bambo/Documents/studia/sieci/SK2-chess-java/src/bP.png"),

    wK("file:/home/bambo/Documents/studia/sieci/SK2-chess-java/src/wK.png"),
    wQ ("file:/home/bambo/Documents/studia/sieci/SK2-chess-java/src/wQ.png"),
    wB("file:/home/bambo/Documents/studia/sieci/SK2-chess-java/src/wB.png"),
    wN("file:/home/bambo/Documents/studia/sieci/SK2-chess-java/src/wN.png"),
    wR("file:/home/bambo/Documents/studia/sieci/SK2-chess-java/src/wR.png"),
    wP("file:/home/bambo/Documents/studia/sieci/SK2-chess-java/src/wP.png");


    final String pieceImagePath;

    PieceType(String pieceImagePath) {
        this.pieceImagePath = pieceImagePath;
    }
}
