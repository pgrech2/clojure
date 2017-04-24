(ns clojure-practice.brian-will
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn factorial [n]
  (if (= n 0) 1
      (* n (factorial (dec n)))))

(defn test [t] (str t))


                                        ; Print 1 through 100
                                        ; divisible by 3 - fizz
                                        ; divisible by 5 - buzz
                                        ; both - fizzbuzz


(defn rem-10 [x]
  (= 0 (rem x 10)))



(defn fizzbuzz [n]
  (loop [i 1]
    (when i <= n
          (print i)
          (recur (inc i)))))

(defn rem-5 [x]
  (= 0 (rem x 5)))

(defn rem-3 [x]
  (= 0 (rem x 3)))


(defn fizzbuzz [n]
  (loop [i 1]
    (if (<= i n)
      (do
        (if (and (rem-5 i) (rem-3 i))
          (println (str i " -fizzbuzz"))
          (if (rem-5 i)
            (println (str i " -buzz"))
            (if (rem-3 i)
              (println (str i " -fizz"))
              (println i))))
        (recur (inc i))))))


(defn fizzbuzz-cond [n]
  (loop [i 1]
    (if (<= i n)
      (do
        (cond
          (and (rem-5 i) (rem-3 i)) (println (str i" -fizzbuzz"))
          (rem-5 i) (println (str i " -buzz"))
          (rem-3 i) (println (str i " -fizz"))
          :else (println i))
        (recur (inc i))))))


(comment "
;; CORE FUNCTION EXAMPLES
(count {3 6, :hi 8, "there" "we go"})
(count [7 8 9 10 11])
(count '(7 8 9 10 11))

(contains? {3 6} 3)
(contains? {3 6} "hi")
(contains? [7 8 9 10 11] 2)
(contains? [7 8 9 10 11] -7)
(contains? '(7 8 9 10 11) 2)

;; Input to conj for MAP should be a vector
(conj {3 6, "hi" 8} {"bye" 7})
(conj {3 6, "hi" 8} {"hi" 7})
(conj {3 6, "hi" 8} ["hi" 7])
(conj [1 2 3] true)
(conj '(1 2 3) false)

(assoc {3 6, "hi" 8} "bye" 7)
(assoc {3 6, "hi" 8} "hi" 7)
(assoc [7 8 9 10 11] 3 true)
(assoc [7 8 9 10 11] 5 true)
(assoc [7 8 9 10 11] 6 true)
(assoc '(7 8 9 10 11) 3 true)

(dissoc {3 6, "hi" 8} "hi")
(dissoc {3 6, "hi" 8} "bye")
; Does nto work on lists or vectors
(dissoc [7 8 9 10 11] 3)
(dissoc '(7 8 9 10 11) 3)

(merge {3 6, "hi" 8})
(merge {3 6, "hi" 8} {"hi" 7, :yo 4})
(merge {3 6, "hi" 8} {"hi" 7, :yo 4} {:yo 5})

(get {3 6, "hi" 8} "hi")
(get {3 6, "hi" 8} "bye")
(get [7 8 9 10 11] 2)
(get [7 8 9 10 11] 6)
(get '(7 8 9 10 11) 2)

(pop [7 8 9 10])
(pop '(7 8 9 10))
(pop {3 6, "hi" 8})

(peek [7 8 9 10])
(peek '(7 8 9 10))
(peek {3 6, "hi" 8})

(seq '(1 2 3 4 5))
(seq [1 2 3 4 5])
(seq {3 6, "hi" 8})
(keys {3 6, "hi" 8})
(vals {3 6, "hi" 8})

(def x (cons 3 nil))
(first x)
(rest x)
(def y (cons 4 '(7 8 9)))
(first y)
(rest y)
(def z (cons 5 (cons 6 (cons 3 nil))))
(first z)
(rest z)
(first (rest z))
(rest (rest z))

(range)			;; infinite
(range 3)		;; infinite
(range 3 11)
(range 3 11 3)
(range 11 3 -3)
(range 2 5 0.5)

(repeat 3)		;; infinite
(repeat 3 5)

(repeatedly rand)	;;infinite
(repeatedly 3 rand)

(cycle [5 2 4]) 	;;infinite

(iterate dec 2)		;;infinite
")


(defn zeroes []
  (lazy-seq
   (cons 0 (zeroes))))

(defn increasing [n]
  (lazy-seq
   (cons n (increasing (inc n)))))

(comment "
(next [2 3 4])
(next [])		; nil rather than empty sequence
(next [2])		; nil rather than empty sequence

(nth [7 8 9 10 11] 3)
(nth '(7 8 9 10 11) 3)
(nth [7 8 9 10 11] 5)
(nth [7 8 9 10 11] 5 "hi")	; movees to default case

(apply + [7 -3 11])
(apply str ["hello" "world"])
(apply str "hi" "bye" ["hello" "world"])

(map + [1 2 3] [4 5 6])
(map + [1 2 3] [4 5 6 7 8] [3 -1])

(reduce + [1 2 3 4])
(reduce + 20 [1 2 3 4])

(reductions + [1 2 3 4])
(reductions + 20 [1 2 3 4])

(filter even? [1 2 3 4 -2 -1])
(filter odd? [1 2 3 4 -2 -1])

(remove even? [1 2 3 4 -2 -1])
(remove odd? [1 2 3 4 -2 -1])

(take 3 [1 2 3 4 -2 -1])
(take-last 3 [1 2 3 4 -2 -1])
(take-nth 3 [1 2 3 4 -2 -1])

(concat [1 2 3] [4 5] [6])

(interleave [1 2 3] [5 6 7 8] [9 10])
(interpose 3 [7 8 9])
(distinct [1 2 3 3 4 5 5 5])
(reverse [1 2 3])
(flatten [1 2 3 [4 5 6 [7 8 9]]])
(sort [7 2 9 4])
;	default is compare function
(sort > [7 2 9 4])
;	can substitute with other logical functions
")

;;-------------------------
;; Rock Paper Scissors

                                        ; Get a user input
(defn user-hand []
  (println "Play your hand: (r)ock   (p)aper   (s)cissors")
  (let [guess (read-line)]
    (if (get {"r" true "p" true "s" true} guess) guess)))

                                        ; Get a user input
(defn comp-hand []
  (rand-nth ["r" "p" "s"]))

(defn display-hand [u c]
  (println "-----------------------")
  (println (str "User     - " u))
  (println (str "Computer - " c )))

(defn display-winner [w]
  (cond
    (= w nil) (println "User hand INVALID")
    (= w 0) (println "DRAW")
    (= w 1) (println "User WINS!")
    (= w 2) (println "Computer wins :(")))

(defn round-winner [u c]
  (if (> u c)
    (println "USER WINS")
    (println "COMPUTER WINS")))


                                        ; 0 - tie
                                        ; 1 - guess1 wins
                                        ; 2 - guess2 wins
(defn winner? [guess1 guess2]
  (let [guesses [guess1 guess2]]
    (cond
      (= guess1 guess2) 0
      (= guesses ["r" "p"]) 2
      (= guesses ["p" "r"]) 1
      (= guesses ["r" "s"]) 1
      (= guesses ["s" "r"]) 2
      (= guesses ["p" "s"]) 2
      (= guesses ["s" "p"]) 1)))


(defn play-hand []
  (let [user (user-hand)
        comp (comp-hand)
        winner (winner? user comp)]
    (display-hand user comp)
    (display-winner winner)
    [winner]))

                                        ; (defn play-rounds [n]
                                        ; 	(loop [i 1 u_wins 0 c_wins 0]
                                        ; 		(if (or (<= i n) (> u_wins (/ n 2.0)) (> u_wins (/ n 2.0))
                                        ; 			(do
                                        ; 				(var-set winner (play-hand))
                                        ; 				(if (= winner [1]) (inc u_wins))
                                        ; 				(if (= winner [2]) (inc c_wins))
                                        ; 				(recur (inc i) u_wins c_wins)))))
                                        ; 	(round-winner u_wins c_wins))



                                        ; (defn play-rounds [n & {:keys [u_wins c_wins] :or [u_wins 0 c_wins 0] :as game_status}]
                                        ; 	;(var-set u_wins 0)
                                        ; 	;(var-set c_wins 0)
                                        ; 	(while
                                        ; 		(or (> :u_wins (/ n 2.0)) (> :c_wins (/ n 2.0)))
                                        ; 		(do()
                                        ; 			(def winner (play-hand))
                                        ; 			(cond
                                        ; 				(= winner [1]) (inc :u_wins)
                                        ; 				(= winner [2]) (inc :c_wins)))))
