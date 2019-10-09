package skiti.cfwz.mareu;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import skiti.cfwz.mareu.controller.DI;
import skiti.cfwz.mareu.controller.MeetingApiService;
import skiti.cfwz.mareu.model.Meeting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private MeetingApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Meeting> neighbours = service.getNeighbours();
        List<Meeting> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void favoriteNeighbourWithSuccess() {
        Neighbour neighbourToFavorite = service.getNeighbours().get(0);
        service.favoriteNeighbour(neighbourToFavorite);
        assertTrue(neighbourToFavorite.getFavorite());
    }

    @Test
    public void getFavoriteNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        neighbours.get(0).setFavorite(true);
        Neighbour neighbourFavorite = neighbours.get(0);
        neighbours.get(1).setFavorite(false);
        Neighbour neighbourNotFavorite = neighbours.get(1);
        assertFalse(service.getFavoriteNeighbours().contains(neighbourNotFavorite));
        assertTrue(service.getFavoriteNeighbours().contains(neighbourFavorite));
    }
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}