import java.util.*;
import java.io.*;


public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String filename = sc.nextLine();
		Scanner loadData = null;
	 	try
		{
		    loadData = new Scanner( new FileInputStream( filename ) );
		}
		catch(FileNotFoundException e)
		{
            System.out.println("File datafile.txt was not found");
            System.out.println("or could not be opened.");
          	System.exit(0);
		}
		//切出token
        char [] codedetail = new char[999999];
		String [] codetoken = new String[999999];
		String [] tokenid = new String[999999];
		int index=0, tokenindex=0;
            while( loadData.hasNext( ) )
            {
				String input = loadData.nextLine();
                for(int i=0;i<input.length();i++){					
					codedetail[index] = input.charAt(i);
					index++;					   
				}
                codedetail[index] = '\n';
				index++;
                      
		    }
		/*for(int y=0;y<index;y++){
			System.out.println(codedetail[y]);
		}*/
		
		loadData.close( );
		for(int j=0;j<index;j++){
			String temp = "";
		    if(codedetail[j]=='#'||codedetail[j]==','||codedetail[j]==':'||codedetail[j]==';'||codedetail[j]=='\"'||codedetail[j]=='('||codedetail[j]==')'
		     ||codedetail[j]=='['||codedetail[j]==']'||codedetail[j]=='{'||codedetail[j]=='}'||codedetail[j]=='+'||codedetail[j]=='-'||codedetail[j]=='*'
	         ||codedetail[j]=='%'||codedetail[j]=='^'||codedetail[j]=='&'||codedetail[j]=='='||codedetail[j]=='|'||codedetail[j]=='!'||codedetail[j]=='\''
		     ||codedetail[j]=='<'||codedetail[j]=='>'||codedetail[j]=='.'||codedetail[j]=='\\'||codedetail[j]=='\\'){
				temp += codedetail[j];
				codetoken[tokenindex] = temp;
                tokenindex++;								
			}
			if(codedetail[j]=='/'&&codedetail[j+1]=='*'){
				int b = 0;
				for(b=j;b<index;b++){
					temp += codedetail[b];
					if(codedetail[b]=='*'&&codedetail[b+1]=='/'){
						temp += codedetail[b+1];
						codetoken[tokenindex] = temp;
						j = j+(b-j)+2; 
				        tokenindex++;
						break;
					}
				}
			}
			else if(codedetail[j]=='/'&&codedetail[j+1]=='/'){
				int a = 0;
				for(a=j;codedetail[a]!='\n';a++){
					temp += codedetail[a];
				}
				codetoken[tokenindex] = temp;
				j = j+(a-j); 
				tokenindex++;
			}
			else if(codedetail[j]=='/'){
				temp += codedetail[j];
				temp += " ";
				codetoken[tokenindex] = temp;
                tokenindex++;								
			}
			if(Character.toString(codedetail[j]).matches("[a-zA-Z]")){
				int a = 0;
				for(a=j;Character.toString(codedetail[a]).matches("[a-zA-Z0-9]");a++){
					temp += codedetail[a];
				}
				codetoken[tokenindex] = temp;
				j = a-1; 
				tokenindex++;
			}
			if(Character.toString(codedetail[j]).matches("[0-9]")){
				int a = 0;
				for(a=j;Character.toString(codedetail[a]).matches("[0-9.]");a++){
					temp += codedetail[a];
				}
				codetoken[tokenindex] = temp;
				j = a-1; 
				tokenindex++;
			}
			if(Character.toString(codedetail[j]).matches("[\n]+")){
				codetoken[tokenindex] = Character.toString(codedetail[j]);
				tokenindex++;
			}

		}
		/*for(int y=0;y<tokenindex;y++){
			System.out.println(codetoken[y]);
		}*/

		int tokenow = 0, tid=0;
		int Reservedword=0, Libraryname=0, Comment=0, Identifier=0, Constant=0, Operator=0, Comparator=0, Bracket=0, Formatspecifier=0,
      		Pointer=0, Address=0, Punctuation=0, Printedtoken=0, undefine=0 ;
        for(int z=0;z<tokenindex;z++){
			if(codetoken[z].matches("[a-zA-Z]+")){
				if(codetoken[z].compareToIgnoreCase("include")==0||codetoken[z].compareToIgnoreCase("main")==0||codetoken[z].compareToIgnoreCase("char")==0||codetoken[z].compareToIgnoreCase("int")==0||codetoken[z].compareToIgnoreCase("float")==0 
			   ||codetoken[z].compareToIgnoreCase("if")==0||codetoken[z].compareToIgnoreCase("else")==0 ||codetoken[z].compareToIgnoreCase("elseif")==0 ||codetoken[z].compareToIgnoreCase("for")==0||codetoken[z].compareTo("while")==0 
               ||codetoken[z].compareToIgnoreCase("do")==0||codetoken[z].compareToIgnoreCase("return")==0||codetoken[z].compareToIgnoreCase("switch")==0||codetoken[z].compareToIgnoreCase("case")==0||codetoken[z].compareTo("printf")==0
               ||codetoken[z].compareToIgnoreCase("scanf")==0			){
				   int len = codetoken[z].length();
               	   tokenow++;
				   Reservedword++;
				   System.out.println(tokenow+" token "+codetoken[z]+" with length "+len+" belongs to reserved word"); 
			    }else{
					int printtokenlen = codetoken[z].length();
					int set = 1;
					for(int r=0;r<tid;r++){
						if(codetoken[z].compareTo(tokenid[r])==0){	
					        tokenow++;
							Identifier++;
				            System.out.println(tokenow+" token "+codetoken[z]+" with length "+printtokenlen+" belongs to identifier");
							set = 0;
							break;
						}/*else{
							tokenow++;
				            System.out.println(tokenow+" token "+codetoken[z]+" with length "+printtokenlen+" belongs to Undefinetoken");
							break;
						}*/
					}	
						if(set == 1){
							tokenow++;
							undefine++;
				            System.out.println(tokenow+" token "+codetoken[z]+" with length "+printtokenlen+" belongs to Undefinetoken");
							for(int t=z;t<tokenindex;t++){
								if(codetoken[t].compareTo("\n")==0){
									z = t;
									break;
								}
							}
						}
                }				
               
			}
			//判斷如果是include後面一定接library name			
            if(codetoken[z].compareToIgnoreCase("include")==0&&codetoken[z+1].matches("[<]")){
				String lentemp = "";
				for(int g=z+1;g<tokenindex;g++){
					lentemp += codetoken[g];
					if(codetoken[g].matches("[>]")){
						int templen = lentemp.length();
						tokenow++;
						Libraryname++;
				        System.out.println(tokenow+" token "+lentemp+" with length "+templen+" belongs to library name");
						z = z + (g-z-1)+2;
						break;
					}
				}
			}
			if(codetoken[z].matches("[<]")&&codetoken[z+1].compareToIgnoreCase("stdio")==0){
				String lentemp = "";
				for(int g=z;g<tokenindex;g++){
					lentemp += codetoken[g];
					if(codetoken[g].matches("[>]")){
						int templen = lentemp.length();
						tokenow++;
						Libraryname++;
				        System.out.println(tokenow+" token "+lentemp+" with length "+templen+" belongs to library name");
						z = z + (g-z)+1;
						break;
					}
				}
			}
			//判斷int main
			if(codetoken[z].compareToIgnoreCase("int")==0&&codetoken[z+1].compareToIgnoreCase("main")==0){
				int g = z+1;
				while(true){
					if(codetoken[g].matches("[\\(\\)]")){
						tokenow++;
						Bracket++;
				        System.out.println(tokenow+" token "+codetoken[g]+" with length 1 belongs to bracket");
						g++;
					}else if(codetoken[g].compareTo("void")==0||codetoken[g].compareTo("main")==0){
						tokenow++;
						Reservedword++;
						System.out.println(tokenow+" token "+codetoken[g]+" with length "+codetoken[g].length()+" belongs to reserved word");
						g++;
					}else if(codetoken[g].matches("[\\{]")){
						tokenow++;
						Bracket++;
				        System.out.println(tokenow+" token "+codetoken[g]+" with length 1 belongs to bracket");
						z = g;
						break;
					}
				}			
			}
			
			//判斷punctuation
			if(codetoken[z].matches("[,;:#\"\']")){
				tokenow++;
				Punctuation++;
				System.out.println(tokenow+" token "+codetoken[z]+" with length 1 belongs to punctuation");
			}
			//如果是int float char 後面會接 identifier
			if((codetoken[z].compareToIgnoreCase("int")==0&&codetoken[z+1].compareTo(")")!=0)||(codetoken[z].compareToIgnoreCase("float")==0&&codetoken[z+1].compareTo(")")!=0)||(codetoken[z].compareToIgnoreCase("char")==0&&codetoken[z+1].compareTo(")")!=0)){
				int g = z+1;
				while(true){
					if(codetoken[g].matches("[*]")){
						String temp = "";
						temp = codetoken[g]+codetoken[g+1];
						tokenow++;
						Pointer++;
						System.out.println(tokenow+" token "+temp+" with length "+temp.length()+" belongs to pointer");
						tokenid[tid] = temp;
						tokenid[tid+1] = codetoken[g+1];
						tid =tid + 2;
						g = g+2;
					}else if(codetoken[g].matches("[,]")){
						tokenow++;
						Punctuation++;
				        System.out.println(tokenow+" token "+codetoken[g]+" with length 1 belongs to punctuation");
						g++;
					}else if(codetoken[g].matches("[;]")){
						tokenow++;
						Punctuation++;
				        System.out.println(tokenow+" token "+codetoken[g]+" with length 1 belongs to punctuation");
						z = g;
						break;
					}else if(codetoken[g].matches("[=]")){
						tokenow++;
						Operator++;
				        System.out.println(tokenow+" token "+codetoken[g]+" with length 1 belongs to operator");
						if(codetoken[g+1].matches("[\']")){
							tokenow++;
							Punctuation++;
				            System.out.println(tokenow+" token "+codetoken[g+1]+" with length 1 belongs to punctuation");
							tokenow++;
							Constant++;
				            System.out.println(tokenow+" token "+codetoken[g+2]+" with length "+codetoken[g+2].length()+" belongs to constant");
							tokenow++;
							Punctuation++;
				            System.out.println(tokenow+" token "+codetoken[g+3]+" with length 1 belongs to punctuation");
							g = g+4;
						}else{
							tokenow++;
							Constant++;
				            System.out.println(tokenow+" token "+codetoken[g+1]+" with length "+codetoken[g+1].length()+" belongs to constant");
						    g = g+2;
						}						
					}else{
						/*int dee = 0;
						if(codetoken[g+1].matches("[_]")){
							String tee = "";
							tee = codetoken[g]+codetoken[g+1]+codetoken[g+2];
							tokenow++;
						    Identifier++;
				            System.out.println(tokenow+" token "+tee+" with length "+tee.length()+" belongs to identifier");
						    tokenid[tid] = tee;
						    tid++;
							dee = 1;
						    g = g+3;
						}
						if(dee==0){*/
						   tokenow++;
						   Identifier++;
				           System.out.println(tokenow+" token "+codetoken[g]+" with length "+codetoken[g].length()+" belongs to identifier");
						   tokenid[tid] = codetoken[g];
						   tid++;
						   g++;
						/*}*/
					}
					
				}
			}
			//如果是print scanf 後面情況
			if(codetoken[z].compareToIgnoreCase("printf")==0||codetoken[z].compareToIgnoreCase("scanf")==0){
				int g = z+1;
				while(true){
					if(codetoken[g].matches("[\\(\\)]")){
						tokenow++;
						Bracket++;
				        System.out.println(tokenow+" token "+codetoken[g]+" with length 1 belongs to bracket");
						g++;
					}else if(codetoken[g].matches("[,\"]")){
						tokenow++;
						Punctuation++;
				        System.out.println(tokenow+" token "+codetoken[g]+" with length 1 belongs to punctuation");
						g++;
					}else if(codetoken[g].matches("[%]")){
						String temp = "";
						temp = codetoken[g]+codetoken[g+1];
						tokenow++;
						Formatspecifier++;
						System.out.println(tokenow+" token "+temp+" with length 2 belongs to format specifier");
						g = g+2;
					}else if(codetoken[g].matches("[&]")){
						String temp = "";
						temp = codetoken[g]+codetoken[g+1];
						tokenow++;
						Address++;
						System.out.println(tokenow+" token "+temp+" with length 2 belongs to address");
						g = g+2;
					}else if(codetoken[g].matches("[\\\\]")&&codetoken[g+1].matches("[ntr]")){
						String temp = "";
						temp = codetoken[g]+codetoken[g+1];
						tokenow++;
						Formatspecifier++;
						System.out.println(tokenow+" token "+temp+" with length 2 belongs to format specifier");
						g = g+2;
					}else if(codetoken[g].matches("[;]")){
						tokenow++;
						Punctuation++;
				        System.out.println(tokenow+" token "+codetoken[g]+" with length 1 belongs to punctuation");
						z = g;
						break;
					}else{
						int set = 0;
						if(codetoken[g-1].matches("[,]")){
							tokenow++;
						    Identifier++;
				            System.out.println(tokenow+" token "+codetoken[g]+" with length "+codetoken[g].length()+" belongs to identifier");
						    g++;
							set = 1;
						}
						if(set==0){
						    tokenow++;
						    Printedtoken++;
				            System.out.println(tokenow+" token "+codetoken[g]+" with length "+codetoken[g].length()+" belongs to printed token");
						    g++;
						}
					}
					
				}
			}
			if(codetoken[z].matches("[*]")&&codetoken[z-1].matches("[\\(\\)=+-/;]")){
				String temp = "";
				temp = codetoken[z]+codetoken[z+1];
				tokenow++;
				Pointer++;
				System.out.println(tokenow+" token "+temp+" with length "+temp.length()+" belongs to pointer");
				z++;
			}
			if(codetoken[z].matches("[-]")&&codetoken[z-1].matches("[\\(\\)=+-/]")){
				String temp = "";
				temp = codetoken[z]+codetoken[z+1];
				tokenow++;
				Constant++;
				System.out.println(tokenow+" token "+temp+" with length "+temp.length()+" belongs to constant");
				z++;
			}
			else if(codetoken[z].matches("[0123456789.]+")){
				tokenow++;
				Constant++;
				System.out.println(tokenow+" token "+codetoken[z]+" with length "+codetoken[z].length()+" belongs to constant");
			}
			if((codetoken[z].matches("[=]")&&codetoken[z+1].matches("[=]"))||(codetoken[z].matches("[!]")&&codetoken[z+1].matches("[=]"))||
			  (codetoken[z].matches("[>]")&&codetoken[z+1].matches("[=]"))||(codetoken[z].matches("[<]")&&codetoken[z+1].matches("[=]"))){
				tokenow++;
				Comparator++;
				System.out.println(tokenow+" token "+codetoken[z]+codetoken[z+1]+" with length 2 belongs to comparator");
				z++;
			}
			else if(codetoken[z].matches("[><]")){
				tokenow++;
				Comparator++;
				System.out.println(tokenow+" token "+codetoken[z]+" with length 1 belongs to comparator");
			}
			else if((codetoken[z].matches("[+]")&&codetoken[z+1].matches("[+]"))||(codetoken[z].matches("[-]")&&codetoken[z+1].matches("[-]"))){
				tokenow++;
				Operator++;
				System.out.println(tokenow+" token "+codetoken[z]+codetoken[z+1]+" with length 2 belongs to operator");
				z++;
			}
			else if(codetoken[z].matches("[+-/%*&=|^]")||(codetoken[z].charAt(0)=='/'&&codetoken[z].charAt(1)== ' ')){
				/*int de = 1;
				if(codetoken[z].matches("[*]")&&codetoken[z-1].matches("[=+-;]")){
					String temp = "";
					temp = codetoken[z]+codetoken[z+1];
					tokenow++;
					Pointer++;
					System.out.println(tokenow+" token "+temp+" with length "+temp.length()+" belongs to pointer");
					de = 0;
					z++;
				}
				if(de==1){*/
				    tokenow++;
				    Operator++;
				    System.out.println(tokenow+" token "+codetoken[z]+" with length 1 belongs to operator");
				/*}*/
			}
			//判斷註解
			if(codetoken[z].charAt(0)=='/'&&codetoken[z].charAt(1)=='/'){
				tokenow++;
				Comment++;
				System.out.println(tokenow+" token "+codetoken[z]+" with length -1 belongs to comment");
			}
			if(codetoken[z].charAt(0)=='/'&&codetoken[z].charAt(1)=='*'){
				tokenow++;
				Comment++;
				System.out.println(tokenow+" token "+codetoken[z]+" with length -1 belongs to comment");
			}
			//判斷bracket
			if(codetoken[z].matches("[\\(\\)\\{\\}\\[\\]]")){
				tokenow++;
				Bracket++;
				System.out.println(tokenow+" token "+codetoken[z]+" with length 1 belongs to bracket");
			}

		}
		/*for(int y=0;y<tid;y++){
			System.out.println(tokenid[y]);
		}*/
		
		System.out.println();
		System.out.println();
		System.out.println("Total: "+tokenow+" tokens");
		System.out.println();
		System.out.println();
		System.out.println("Reserved word: "+Reservedword);
		System.out.println("Library name: "+Libraryname);
		System.out.println("Comment: "+Comment);
		System.out.println("Identifier: "+Identifier);
		System.out.println("Constant: "+Constant);
		System.out.println("Operator: "+Operator);
		System.out.println("Comparator: "+Comparator);
		System.out.println("Bracket: "+Bracket);
		System.out.println("Format specifier: "+Formatspecifier);
		System.out.println("Pointer: "+Pointer);
		System.out.println("Address: "+Address);
		System.out.println("Punctuation: "+Punctuation);
		System.out.println("Printed token: "+Printedtoken);
		System.out.println("Undefine token: "+undefine);
	}
	}