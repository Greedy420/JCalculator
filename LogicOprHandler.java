//Operand Handler Logic
/**
*Kelas untuk menangani operan logika
*/
class LogicOprHandler implements OperandHandler {
public	LogicOprHandler() {this.value = 0;}
public	LogicOprHandler(LogicOprHandler AH) {this.value = AH.value;}

public	void setvalue(String value)
		{
			try {
				if (!value.equals("true") && !value.equals("false") && !value.equals("1") && !value.equals("0")) {
					throw new ArithmeticException();
				}
				float f = 0;

				if (value.equals("0") || value.equals("1")) {
					f = Float.parseFloat(value);
					this.value = f;
				}
				else {
					if (value.equals("true")) {
						this.value = 1;
					}
					else {
						if (value.equals("false")) {
							this.value = 0;
						}
					}
				}
			}
			catch (ArithmeticException e) {
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
