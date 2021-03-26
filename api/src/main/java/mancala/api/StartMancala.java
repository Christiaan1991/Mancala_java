package mancala.api;

import java.io.IOException;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import mancala.api.models.*;
import mancala.domain.MancalaImpl;

@Path("/start")
public class StartMancala {
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response initialize(
			@Context HttpServletRequest request, 
			PlayerInput players) {
        var mancala = new MancalaImpl();
        String namePlayer1 = players.getNameplayer1();
		String namePlayer2 = players.getNameplayer2();
		
        HttpSession session = request.getSession(true);
        session.setAttribute("mancala", mancala);
        session.setAttribute("player1", namePlayer1);
        session.setAttribute("player2", namePlayer2);

		System.out.println(mancala.isPlayersTurn(1));
		System.out.println(mancala.isPlayersTurn(2));

		var output = new Mancala(mancala, namePlayer1, namePlayer2);

		//give turn to player 1
		System.out.println(output.getPlayers()[0].getHasTurn());
		System.out.println(output.getPlayers()[1].getHasTurn());

		return Response.status(200).entity(output).build();
	}
}
