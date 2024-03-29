package boardGame;

public class Board {
	private int rows;
	private int colunms;
	private Piece[][] pieces;
	
	public Board(int rows, int colunms) {
		if(rows < 1 || colunms < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.colunms = colunms;
		pieces = new Piece[rows][colunms];
	}

	public int getRows() {
		return rows;
	}
 
	public int getColunms() {
		return colunms;
	}
	
	public Piece pieces(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece pieces(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("there is already a piece on position" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("position not on the board");
		}
		if(pieces(position) == null) {
			return null;
		}
		Piece aux = pieces(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	private boolean positionExists(int row, int col) {
		return row >= 0 && row < rows && col >= 0 && col < colunms;
	}
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("position not on the board");
		}
		return pieces(position) != null;
	}
	
	
	
	
}
