
(ns intersection-observer.side-effects
    (:require [dom.api                     :as dom]
              [common-state.api :as common-state]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn setup-observer!
  ; @description
  ; Creates an intersection observer for observing the DOM element returned by the given ':get-element-f' function.
  ;
  ; @param (keyword) observer-id
  ; @param (map) observer-props
  ; {:callback-f (function)
  ;  :get-element-f (function)
  ;   Takes the observer ID as parameter.
  ;   Must return a 'DOM Element' object.}
  ;
  ; @usage
  ; (setup-observer! :my-observer {:callback-f    (fn [intersecting?] ...)
  ;                                :get-element-f (fn [_] (.getElementById js/document "my-element"))})
  ; =>
  ; #object[IntersectionObserver]
  ;
  ; @return (DOM IntersectionObserver object)
  [observer-id {:keys [callback-f get-element-f]}]
  (if get-element-f (if-let [element (get-element-f observer-id)]
                            (let [observer (dom/create-intersection-observer! callback-f)]
                                 (common-state/assoc-state! :intersection-observer :observers observer-id observer)
                                 (dom/observe-element-intersection! observer element)))))

(defn remove-observer!
  ; @description
  ; Quits observing the DOM element returned by the given ':get-element-f' function,
  ; then disconnects the corresponding intersection observer.
  ;
  ; @param (keyword) observer-id
  ; @param (map) observer-props
  ; {:get-element-f (function)
  ;   Takes the observer ID as parameter.
  ;   Must return a DOM Element object.}
  ;
  ; @usage
  ; (remove-observer! :my-observer {:get-element-f (fn [_] (.getElementById js/document "my-element")})
  ; =>
  ; nil
  ;
  ; @return (nil)
  [observer-id {:keys [get-element-f]}]
  (if get-element-f (if-let [element (get-element-f observer-id)]
                            (when-let [observer (common-state/get-state :intersection-observer :observers observer-id)]
                                      (common-state/dissoc-state! :intersection-observer :observers observer-id)
                                      (-> observer (dom/unobserve-element-intersection! element))
                                      (-> observer (dom/disconnect-intersection-observer!))))))
