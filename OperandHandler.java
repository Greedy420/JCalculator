//Interface

interface OperandHandler {

	/**
    @brief
    I.S: value berisi operan; F.S: Atribut value terisi dengan nilai dari operan dalam bilangan arab
    */
	public void setvalue(String value);

	/**
    @brief
    I.S: Sembarang; F.S: Mengembalikan nilai atribut value
    */
	public float getvalue();

	/**
    @brief
    I.S: input adalah nilai operan dalam bilangan arab; F.S: Mengembalikan string berisi format operan yang sesuai
    */
	public String returnval(float input);

    /**
    *\brief
    *Menyimpan nilai operan yang sudah dikonversi ke bilangan arab
    */
	float value = 0;
};
