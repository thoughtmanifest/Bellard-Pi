(use 'clojure.contrib.generic.math-functions)

;pi = SUMMATION 
; (1/2^6) * 
; ((-1)^n/2^10n) *
; (-(2^5/4n+1) -
;  (1/4n+3) +
;  (2^8/10n+1) -
;  (2^6/10n+3) -
;  (2^2/10n+5) -
;  (2^2/10n+7) +
;  (1/10n+9))
(defn mult4 [n] (* 4 n))
(defn mult10 [n] (* 10 n))
(defn arg1 [n] (- (/ (pow 2 5) (+ (mult4 n) 1))))
(defn arg2 [n] (- (/ 1 (+ (mult4 n) 3))))
(defn arg3 [n] (/ (pow 2 8) (+ (mult10 n) 1)))
(defn arg4 [n] (- (/ (pow 2 6) (+ (mult10 n) 3))))
(defn arg5 [n] (- (/ (pow 2 2) (+ (mult10 n) 5))))
(defn arg6 [n] (- (/ (pow 2 2) (+ (mult10 n) 7))))
(defn arg7 [n] (/ 1 (+ (mult10 n) 9)))
(defn marg1 [n] (/ (pow -1 n) (pow 2 (mult10 n))))
(def marg2 (/ 1 (pow 2 6)))
(defn bellard [n]
	(* (marg1 n) marg2 
		(+ (arg1 n) (arg2 n) (arg3 n) (arg4 n) (arg5 n) (arg6 n) (arg7 n))))


