(ns pi-finder
	(:use clojure.contrib.generic.math-functions))

(defn mult4
	"multiply n * 4" 
	[n] 
	(* 4 n))
	
(defn mult10 
	"multiply n * 10"
	[n] 
	(* 10 n))

(defn calc+1div2pow6 
	"calculate (1/2^6)"
	[]
	(/ 1 (pow 2 6)))

(defn calc-1powNdiv2pow10N 
	"calculate ((-1)^n/2^10n)"
	[N] 
	(/ (pow -1 N) (pow 2 (mult10 N))))
	
(defn calc-2pow5div4n+1
	"calculate -(2^5/4n+1)"
	[n] 
		(- (/ (pow 2 5) (+ (mult4 n) 1))))
		
(defn calc-1div4n+3 
	"calculate -(1/4n+3)"
	[n] 
		(- (/ 1 (+ (mult4 n) 3))))
		
(defn calc+2pow8div10n+1 
	"calculate +(2^8/10n+1)"
	[n] 
		(/ (pow 2 8) (+ (mult10 n) 1)))
		
(defn calc-2pow6div10n+3 
	"calculate -(2^6/10n+3)"
	[n] 
		(- (/ (pow 2 6) (+ (mult10 n) 3))))
		
(defn calc-2pow2div10n+5 
	"calculate -(2^2/10n+5)"
	[n] 
		(- (/ (pow 2 2) (+ (mult10 n) 5))))
		
(defn calc-2pow2div10n+7 
	"calculate -(2^2/10n+7)"
	[n] 
		(- (/ (pow 2 2) (+ (mult10 n) 7))))
		
(defn calc+1div10n+9 
	"calculate +(1/10n+9)"
	[n] 
		(/ 1 (+ (mult10 n) 9)))

; pi = SUMMATION n=0 to infinity of
;   (1/2^6) 
; * ((-1)^n/2^10n)
; * (- (2^5/4n+1)
;  	 - (1/4n+3)
;    + (2^8/10n+1) 
;    - (2^6/10n+3)
;    - (2^2/10n+5)
;    - (2^2/10n+7)
;    + (1/10n+9))
(defn bellard 
	"pi = SUMMATION n=0 to infinity of
	   (1/2^6) 
	 * ((-1)^n/2^10n)
	 * (- (2^5/4n+1)
	    - (1/4n+3)
	    + (2^8/10n+1)
	    - (2^6/10n+3)
	    - (2^2/10n+5)
	    - (2^2/10n+7)
	    + (1/10n+9))"
	[n]
	(* (calc+1div2pow6)
		(calc-1powNdiv2pow10N n)
		(+ (calc-2pow5div4n+1 n)
			(calc-1div4n+3 n)
			(calc+2pow8div10n+1 n)
			(calc-2pow6div10n+3 n)
			(calc-2pow2div10n+5 n)
			(calc-2pow2div10n+7 n)
			(calc+1div10n+9 n))))
			
(defn better-bellard 
	"iterates through the bellard formula for pi an [n] number of times, 
	 supplying more meaningful decimals of pi for every iteration"
	[n]
	(loop [cnt 0
		   pi 0.0]
		(if (> cnt n)
			pi
			(recur (inc cnt) (+ pi (bellard cnt))))))

;(defn mul_mod [a b]
;	(rem (* a b) 1))

;(defn inv_mod [x y]
;	(/ y x))

