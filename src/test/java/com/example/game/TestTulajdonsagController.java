package com.example.game;

import com.example.game.hos.TulajdonsagController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTulajdonsagController {

    @Test
    public void testElsoArSzamitas(){
        TulajdonsagController tk = new TulajdonsagController();
        tk.setVasarlasokSzama(2);
        assertEquals(tk.arSzamitas(), 7, "Sajnos itt valami hiba van :( ");
    }

    @Test
    public void testMasodikArSzamitas(){
        TulajdonsagController tk = new TulajdonsagController();
        tk.setVasarlasokSzama(4);
        assertEquals(tk.arSzamitas(), 9, "Sajnos itt valami hiba van :( ");
    }

    @Test
    public void testArSzamitasNullara(){
        TulajdonsagController tk = new TulajdonsagController();
        tk.setVasarlasokSzama(0);
        assertEquals(tk.arSzamitas(), 5, "Sajnos itt valami hiba van :( ");
    }

}
