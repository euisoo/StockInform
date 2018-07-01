DROP TABLE finance;

CREATE TABLE finance (
	cmpName	      	VARCHAR2(30) NOT NULL,
	revenue      	VARCHAR2(20),      	
	operatingIncome VARCHAR2(20),      	
	netIncome      	VARCHAR2(20),      	
	totalasset      VARCHAR2(20),      	
	totaldebt      	VARCHAR2(20),	      
	capitalGross    VARCHAR2(20),
	netProfitRatio  VARCHAR2(20),
	capex      		VARCHAR2(20),	      	
	fcf      		VARCHAR2(20),	      	      
	roc      		VARCHAR2(20),	     
	roa      		VARCHAR2(20),     
	eps      		VARCHAR2(20),	      	
	per      		VARCHAR2(20),	      
	bps      		VARCHAR2(20),	      	
	pbr      		VARCHAR2(20),	      
	ifrs	      	VARCHAR2(20) NOT NULL,
	year      		VARCHAR2(20) NOT NULL,
	CONSTRAINT finance_cmpName_fk FOREIGN KEY (cmpName) REFERENCES info (cmpName)
);


