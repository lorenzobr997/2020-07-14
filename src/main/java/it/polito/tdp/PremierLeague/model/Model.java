package it.polito.tdp.PremierLeague.model;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Model {
	
	private Graph<Team, DefaultWeightedEdge> grafo;
	private PremierLeagueDAO dao;
	
	public String creaGrafo() {
		
		dao = new PremierLeagueDAO();
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(this.grafo, this.dao.listAllTeams());
		
		return String.format("Grafo con #vertici: %d e #archi: %d" , this.grafo.vertexSet().size(), this.grafo.edgeSet().size());
		
	}

	public List<Team> getAllTeams() {
		dao = new PremierLeagueDAO();
		return this.dao.listAllTeams();
	}
	
}
