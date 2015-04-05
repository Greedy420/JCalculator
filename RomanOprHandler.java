//Operand Handler Romawi
/**
*Kelas untuk menangani operan bilangan romawi
*/
class RomanOprHandler implements OperandHandler {
private float value;

public 	RomanOprHandler() {this.value = 0;}
public 	RomanOprHandler(RomanOprHandler RH) {this.value = RH.value;}

public	void setvalue(String valuestr) {
			try {
				float decimal = 0;
				int x = 0;
				char[] value = valuestr.toCharArray();

				String romanNumeral = valuestr;
				while(value[x] != '\0')
				{
					char convertToDecimal = value[x];

					switch (convertToDecimal)
					{
					case 'M':
						decimal += 1000;
						break;

					case 'D':
						decimal += 500;
						break;

					case 'C':
						decimal += 100;
						break;

					case 'L':
						decimal += 50;
						break;

					case 'X':
						decimal += 10;
						break;

					case 'V':
						decimal += 5;
						break;

					case 'I':
						decimal += 1;
						break;

					default :
						throw new ArithmeticException();
					}
					x++;
				}
				if (romanNumeral.contains("IV"))
				{
					decimal-=2;
				}
				if (romanNumeral.contains("IX"))
				{
					decimal-=2;
				}
				if (romanNumeral.contains("XL"))
				{
					decimal-=20;
				}
				if (romanNumeral.contains("XC"))
				{
					decimal-=20;
				}
				if (romanNumeral.contains("CD"))
				{
					decimal-=200;
				}
				if (romanNumeral.contains("CM"))
				{
					decimal-=200;
				}
				this.value = decimal;
			}
			catch(ArithmeticException e) {
				this.value = 0;
				System.out.println("Wrong Input");
			}
		}
		
public	float getvalue(){
			return value;
		}

public	String returnval(float input) {
			String returnstr = new String();
			int mcount = 0, ccount = 0, icount = 0, xcount = 0;
			float val = input;
			
			val = input;
			while (val != 0) {
				if ((val - 1000)>=0) {
					val = val-1000;
					mcount++;
				}
				else {
					if ((val - 100) >= 0) {
						val = val-100;
						ccount++;
					}
					else {
						if ((val - 10) >= 0) {
							val = val-10;
							xcount++;
						}
						else {
							val = val-1;
							icount++;
						}
					}
				}
			}
			for (int i=1; i<=mcount; i++) {
					returnstr = returnstr + 'M';
				}


			if (ccount == 9) {
				returnstr = returnstr + "CM";
				ccount = ccount - 9;
			}
			else if (ccount >= 5) {
				returnstr = returnstr + "D";
				ccount = ccount - 5;
			}
			else if (ccount == 4) {
				returnstr = returnstr + "CD";
				ccount = ccount - 4;
			}
			for (int i=1; i<=ccount; i++) {
				returnstr = returnstr + 'C';
			}


			if (xcount == 9) {
				returnstr = returnstr + "XC";
				xcount = xcount - 9;
			}
			else if (xcount >= 5) {
				returnstr = returnstr + "L";
				xcount = xcount - 5;
			}
			else if (xcount == 4) {
				returnstr = returnstr + "XL";
				xcount = xcount - 4;
			}
			for (int i=1; i<=xcount; i++) {
				returnstr = returnstr + 'X';
			}


			if (icount == 9) {
				returnstr = returnstr + "IX";
				icount = icount - 9;
			}
			else if (icount >= 5) {
				returnstr = returnstr + "V";
				icount = icount - 5;
			}
			else if (icount == 4) {
				returnstr = returnstr + "IV";
				icount = icount - 4;
			}
			for (int i=1; i<=icount; i++) {
				returnstr = returnstr + 'I';
			}

			return returnstr;
		}
};
