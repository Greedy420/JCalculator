//Operand Handler Angka
/**
*Kelas untuk menangani operan bilangan arab
*/
class AngkaOprHandler implements OperandHandler {
public	AngkaOprHandler() {this.value = 0;}
public	AngkaOprHandler	(AngkaOprHandler AH) {this.value = AH.value;}

public	void setvalue(String valuestr)
		{
			try {
				char[] value = valuestr.toCharArray();
				int once = 0;
				int x = 0;
				float f = 0;
				while (value[x] != '\0') {
					char test = value[x];
					if (test != '0' && test != '1' && test != '2' && test != '3' && test != '4' && test != '5' && test != '6' && test != '7' && test != '8' && test != '9' && test != '.') {
						throw new ArithmeticException();
					}
					if (test == '.' && once == 1)
						throw new ArithmeticException();
					else if (test == '.' && once == 0)
						once = 1;
					x++;
				}
				x = 0;
				f = Float.parseFloat(valuestr);
				this.value = f;
			}
			catch(ArithmeticException e) {
				this.value = 0;
				System.out.println("Wrong Input");
			}
		}

public	float getvalue()
		{
			return value;
		}

public	String returnval(float input)
		{
			String convert = String.valueOf(input);
			return convert;
		}

private	float value;
};
