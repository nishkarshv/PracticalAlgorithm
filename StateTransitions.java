import java.util.Scanner;

enum State{
	ZEROS{
		@Override
	 	State transition(String op)
	 	{
			if(op.equals("1R"))
				return ONES;
			else if(op.equals("2R"))
				return TWOS;
			else if(op.equals("CANCEL"))
				return CANCELLED;
			else
				{System.out.println("Unknown op");
			
			return this;}
	 	}
	},
	ONES{
		@Override
	 	State transition(String op)
	 	{
			if(op.equals("1R"))
				return TWOS;
			else if(op.equals("2R"))
				return THREES;
			else if(op.equals("CANCEL"))
				return CANCELLED;
			else
				{System.out.println("Unknown op");
			return this;}
	 	}
		
	},
	TWOS{
		@Override
	 	State transition(String op)
	 	{
			if(op.equals("1R"))
				return THREES;
			else if(op.equals("2R"))
				return FOURS;
			else if(op.equals("CANCEL"))
				return CANCELLED;
			else
				{System.out.println("Unknown op");
			return this;}
	 	}
	},
	THREES{
		@Override
	 	State transition(String op)
	 	{
			if(op.equals("1R"))
				return FOURS;
			else if(op.equals("CANCEL"))
				return CANCELLED;
			else
				{System.out.println("Unknown op");
			return this;}
	 	}
	},
	FOURS{
		@Override
	 	State transition(String op)
	 	{
			if(op.equals("BUY"))
				return COMPLETED;
			else if(op.equals("CANCEL"))
				return CANCELLED;
			else
				{System.out.println("Unknown op");
			return this;}
	 	}
	},
	CANCELLED{
		@Override
	 	State transition(String op)
	 	{	
			System.out.println("No transition possible now");
			return this;
	 	}
		
	},
	COMPLETED{
		@Override
	 	State transition(String op)
	 	{
			System.out.println("No transition possible now");
			return this;
	 	}
	};
	abstract State transition(String op);
}
public class StateTransitions {
	State state;
	public StateTransitions(){
		state = State.ZEROS;
	}
	public void performTransition(String op)
	{
		state = state.transition(op);
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		StateTransitions st = new StateTransitions();
		String str;
		
		System.out.print(">");
		while(sc.hasNext()){
			//System.out.print(">");
			str = sc.next();
			//System.out.print(str);
			str=str.toUpperCase();
			
			st.performTransition(str);
			//System.out.print("Current State <"+st.state);
			State s1=st.state;
			printstate(s1);
			System.out.print(">");
		}
		
		
	}
	private static void printstate(State st) {
		// TODO Auto-generated method stub
		//if(st)
		if(st.equals(State.ZEROS) ){
			System.out.println("< 0S");
		}else if(st.equals(State.ONES)){
			System.out.println("< 1S");
		}else if(st.equals(State.TWOS)){
			System.out.println("< 2S");
		}else if(st.equals(State.THREES)){
			System.out.println("< 3S");
		}else if(st.equals(State.FOURS)){
			System.out.println("< 4S");
		}else if(st.equals(State.COMPLETED)){
			System.out.println("<! COMPLETED");
		}
		
		
	}
}
