package hu.bme.mit.spaceship;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {
  private TorpedoStore mockTS1;
  private TorpedoStore mockTS2;
  private GT4500 ship;

  @BeforeEach
  public void init(){
    mockTS1 = mock(TorpedoStore.class);
    mockTS2 = mock(TorpedoStore.class);
    this.ship = new GT4500(mockTS1, mockTS2);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(mockTS1.isEmpty()).thenReturn(false);
    when(mockTS2.isEmpty()).thenReturn(false);
    when(mockTS1.fire(1)).thenReturn(true);
    when(mockTS2.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
  }

    @Test
    public void fireTorpedo_Single_Empty_Failure(){
        // Arrange
        when(mockTS1.isEmpty()).thenReturn(true);
        when(mockTS2.isEmpty()).thenReturn(true);

        // Act
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);

        // Assert
        assertEquals(false, result);
    }

    @Test
    public void fireTorpedo_Single_One_Empty_Success(){
        // Arrange
        when(mockTS1.isEmpty()).thenReturn(true);
        when(mockTS2.isEmpty()).thenReturn(false);
        when(mockTS2.fire(1)).thenReturn(true);

        // Act
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);

        // Assert
        assertEquals(true, result);
    }

    @Test
    public void fireTorpedo_Alternate_Success(){
        // Arrange
        when(mockTS1.isEmpty()).thenReturn(false);
        when(mockTS2.isEmpty()).thenReturn(false);
        when(mockTS1.fire(1)).thenReturn(true);
        when(mockTS2.fire(1)).thenReturn(true);

        // Act
        boolean result1 = ship.fireTorpedo(FiringMode.SINGLE);

        boolean result2 = ship.fireTorpedo(FiringMode.SINGLE);
        boolean result = result1 && result2;

        // Assert
        assertEquals(true, result);
    }

    @Test
    public void fireTorpedo_Alternate_Third_Failure(){
        // Arrange
        when(mockTS1.isEmpty()).thenReturn(false);
        when(mockTS2.isEmpty()).thenReturn(false);
        when(mockTS1.fire(1)).thenReturn(true);
        when(mockTS2.fire(1)).thenReturn(true);

        // Act
        ship.fireTorpedo(FiringMode.SINGLE);
        ship.fireTorpedo(FiringMode.SINGLE);

        when(mockTS1.isEmpty()).thenReturn(true);

        boolean result = ship.fireTorpedo(FiringMode.SINGLE);

        // Assert
        assertEquals(true, result);
    }

    @Test
    public void fireTorpedo_Alternate_Second_Empty_Success(){
        // Arrange
        when(mockTS1.isEmpty()).thenReturn(false);
        when(mockTS2.isEmpty()).thenReturn(true);
        when(mockTS1.fire(1)).thenReturn(true);

        // Act
        boolean result1 = ship.fireTorpedo(FiringMode.SINGLE);
        boolean result2 = ship.fireTorpedo(FiringMode.SINGLE);
        boolean result = result1 && result2;

        // Assert
        assertEquals(true, result);
    }

    @Test
    public void fireTorpedo_First_Fail_No_Second_Failure(){
        // Arrange
        when(mockTS1.isEmpty()).thenReturn(false);
        when(mockTS2.isEmpty()).thenReturn(false);
        when(mockTS1.fire(1)).thenReturn(false);
        when(mockTS2.fire(1)).thenReturn(true);

        // Act
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);

        // Assert
        assertEquals(false, result);
    }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(mockTS1.isEmpty()).thenReturn(false);
    when(mockTS2.isEmpty()).thenReturn(false);
    when(mockTS1.fire(1)).thenReturn(true);
    when(mockTS2.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
  }

    @Test
    public void fireTorpedo_All_Second_Empty_Success(){
        // Arrange
        when(mockTS1.isEmpty()).thenReturn(false);
        when(mockTS2.isEmpty()).thenReturn(true);
        when(mockTS1.fire(1)).thenReturn(true);

        // Act
        boolean result = ship.fireTorpedo(FiringMode.ALL);

        // Assert
        assertEquals(true, result);
    }

    @Test
    public void fireTorpedo_All_First_Empty_Success(){
        // Arrange
        when(mockTS1.isEmpty()).thenReturn(true);
        when(mockTS2.isEmpty()).thenReturn(false);
        when(mockTS2.fire(1)).thenReturn(true);

        // Act
        boolean result = ship.fireTorpedo(FiringMode.ALL);

        // Assert
        assertEquals(true, result);
    }

}
