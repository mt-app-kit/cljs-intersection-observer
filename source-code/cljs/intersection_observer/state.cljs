
(ns intersection-observer.state)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @description
; Stored 'IntersectionObserver' objects.
;
; @atom (map)
; {:my-observer (DOM IntersectionObserver object)}
;
; @usage
; (deref OBSERVERS)
; =>
; {:my-observer #object[IntersectionObserver]}
(def OBSERVERS (atom {}))
