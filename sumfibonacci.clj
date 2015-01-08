;(defn fib [x]
  ;(if (<= x 1) 1
  ;(+ (fib (- x 1)) (fib (- x 2)))))

;(def fib-seq ((fn rfib [a b]
                ;(if true (lazy-seq (cons a (rfib b (+ a b))))))
              ;0 1))

(defn fib-seq2 [top]
  ((fn rfib2 [a b]
       (if (< a top)
       (cons a (lazy-seq (rfib2 b (+ a b)))))
       )
   0 1))


(defn sumall [coll]
  (if (= coll ()) 0
    (+ (first coll) (sumall (rest coll)))))

(println (fib-seq2 5000000))
(println (sumall (filter (fn [x] (= 0 (mod x 2))) (fib-seq2 5000000))))
(println (sumall '(100 100 100 100 100 100 100 100)))
