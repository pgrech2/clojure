(ns clojure-practice.leet-code
  (:require [clojure-practice.utils :as util]))

;; Question 1
;; Two Sums
(defn two-sums
  [target coll]
  (->> (map-indexed
        (fn [i fst]
          (let [rst     (drop (inc i) coll)
                tgt-idx (.indexOf (map #(+ fst %) rst) target)]
            (when (not= -1 tgt-idx)
              [i (inc (+ i tgt-idx))]))) coll)
       (keep identity)
       first))

;; Question 2
;; Add two numbers
(defn number
  [coll]
  (->> (reverse coll)
       (map-indexed (fn [i n] (* n (util/exp 10 i))))
       (apply +)))

(defn add-two-numbers
  [coll1 coll2]
  (util/digits (+ (number coll1)
                  (number coll2))))

;; Question 3
;; Longest substring
(defn longest-substr [s]
  (loop [chars   (util/char-seq s)
         sub-str []
         max-cnt 0]
    (if (empty? chars)
      max-cnt
      (let [nxt (first chars)
            rst (rest chars)]
        (if (.contains sub-str nxt)
          (recur rst
                 (subvec sub-str 1)
                 max-cnt)
          (recur rst
                 (conj sub-str nxt)
                 (-> (count sub-str)
                     (inc)
                     (max max-cnt))))))))

;; Question 4
;; Median of two arrays
(defn median-arrays
  [a1 a2]
  (let [a   (sort < (into a1 a2))
        cnt (count a)]
    (if (even? cnt)
      (let [split (split-at (quot cnt 2) a)]
        (-> (last (first split))
            (+ (first (second split)))
            (/ 2)))
      (-> (count a)
          (quot 2)
          (->> (nth a))))))

;; Question 5
;; Longest substring palindrome
(defn longest-palindrome
  [s]
  (let [chrs     (util/char-vec s)
        chrs-cnt (count chrs)]
    (when (< chrs-cnt 1000)
      (->> (+ 2 chrs-cnt)
           (range 2)
           (mapcat #(partition % 1 chrs))
           (reduce (fn [l ss]
                     (cond
                       (util/palindrome? ss)
                       (conj l ss)
                       :else l)) [])))))
