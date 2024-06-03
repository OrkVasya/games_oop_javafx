package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.black.BishopBlack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class BlackBishopTest {

    @Test
    public void whenBlackBishopPositionTheSame() {
        Figure bishop = new BishopBlack(Cell.C8);
        assertEquals(Cell.C8, bishop.position());
    }

    @Test
    public void whenBlackBishopCopyPositionTheSame() {
        Figure bishop = new BishopBlack(Cell.C8);
        Figure copy = bishop.copy(Cell.F8);
        assertEquals(Cell.F8, copy.position());
    }

    @Test
    public void whenBlackBishopMovesCheckWay() {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] way = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(way, bishop.way(Cell.G5));
    }

    @Test
    public void whenBlackBishopWrongMove() {
        Figure bishop = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            bishop.way(Cell.C2);
        });
        assertThat(exception.getMessage()).isEqualTo(
                String.format("Couldn't move by diagonal from %s to %s", Cell.C1, Cell.C2)
        );
    }
}
