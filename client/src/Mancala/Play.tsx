import React, {useState} from "react";
import type { GameState } from "../gameState";
import "./Play.css";

type PlayProps = {
    gameState: GameState;
    setGameState(newGameState: GameState): void;
}

export function Play({ gameState, setGameState }: PlayProps) {
	
	const [indexnum, setIndex] = useState("");
	const [errorMessage, setErrorMessage] = useState("");

	async function pickIndex(e: React.FormEvent) {
        e.preventDefault();

        try {
            const response = await fetch('mancala/api/move', {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({index: indexnum})
            });

            if (response.ok) {
                const gameState = await response.json();
                setGameState(gameState);
            } else {
                console.error(response.statusText);
            }
        } catch (error) {
            console.error(error.toString());
        }

    }

    console.log(gameState);

    if(gameState.players[0].hasTurn == true){
    	status = gameState.players[0].name;
    }
    else if(gameState.players[1].hasTurn == true){
    	status = gameState.players[1].name;
    }
	

    return (
        <div>
            <p>{gameState.players[0].name} vs {gameState.players[1].name}</p>
            <form onSubmit={(e) => pickIndex(e)}>
            <div className="status">Turn: {status}</div>
            <div className="board">
            	<div className="otherplayerpit">
	            	<button className = "pit" onClick={(e) => setIndex("12")}>{gameState.players[1].pits[5].nrOfStones}</button>
	            	<button className = "pit" onClick={(e) => setIndex("11")}>{gameState.players[1].pits[4].nrOfStones}</button>
	            	<button className = "pit" onClick={(e) => setIndex("10")}>{gameState.players[1].pits[3].nrOfStones}</button>
	            	<button className = "pit" onClick={(e) => setIndex("9")}>{gameState.players[1].pits[2].nrOfStones}</button>
	            	<button className = "pit" onClick={(e) => setIndex("8")}>{gameState.players[1].pits[1].nrOfStones}</button>
	            	<button className = "pit" onClick={(e) => setIndex("7")}>{gameState.players[1].pits[0].nrOfStones}</button>  
	            </div>	
          	    <div id="mancalarow">
					<button id="othermancala" onClick={(e) => setIndex("13")}>{gameState.players[1].pits[6].nrOfStones}</button>
					<button id="ownmancala" onClick={(e) => setIndex("6")}>{gameState.players[0].pits[6].nrOfStones}</button>
            	</div>
            	<div className="playerpit">
	            	<button className = "pit" onClick={(e) => setIndex("0")}>{gameState.players[0].pits[0].nrOfStones}</button>
	            	<button className = "pit" onClick={(e) => setIndex("1")}>{gameState.players[0].pits[1].nrOfStones}</button>
	            	<button className = "pit" onClick={(e) => setIndex("2")}>{gameState.players[0].pits[2].nrOfStones}</button>
	            	<button className = "pit" onClick={(e) => setIndex("3")}>{gameState.players[0].pits[3].nrOfStones}</button>
	            	<button className = "pit" onClick={(e) => setIndex("4")}>{gameState.players[0].pits[4].nrOfStones}</button>
	            	<button className = "pit" onClick={(e) => setIndex("5")}>{gameState.players[0].pits[5].nrOfStones}</button>  
	            </div>	

            </div>
            </form>
	          
	        <p className="Message">You picked Pit index: {indexnum}</p>
            
        </div>
    )
}