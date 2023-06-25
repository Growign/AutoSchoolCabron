import React, {useEffect, useMemo, useState} from 'react';
import AnswerButton from './AnswerButton';
import "../../css/QuizComponent.css"
import axios from "axios";

// TODO: почистити код. Рішити чи юзер зможе проходити без аккаунта тести, і якщо так то потрібно зробити силку публічну в spring security. Якщо ні потрібно зробити автоматичне получення accessToken.

const Quiz = () => {
    const [questions, setQuestions] = useState([]);
    const [state, setState] = useState({
        currentQuestion: 0,
        selectedAnswers: Array(questions.length).fill(null),
        quizStarted: false,
        showScore: false,
    });


    useEffect(() => {
        axios.get("http://localhost:8080/quiz/getQuestion", {withCredentials: true})
            .then(response => {
                const question = response.data.map(item => ({
                    id: item.id,
                    jsonQuestion: JSON.parse(item.jsonQuestion)
                }));
                setQuestions(question);
                setState({...state, selectedAnswers: Array(question.length).fill(null)})
            })
        // eslint-disable-next-line
    }, []);

    const {
        handleAnswerSelect,
        handleNextClick,
        handleQuestionNavigation,
        handleStartClick,
        handleRestartClick
    } = useMemo(() => {
        const handleAnswerSelect = (answerIndex) => {
            setState(prevState => {
                const selectedAnswers = prevState.selectedAnswers.map((answer, index) =>
                    index === prevState.currentQuestion ? answerIndex : answer
                );
                const isCorrect = questions[prevState.currentQuestion].jsonQuestion.correctAnswer === answerIndex;
                const showNextButton = !isCorrect;
                const currentQuestion = showNextButton ? prevState.currentQuestion : questions.length - 1 === prevState.currentQuestion ? prevState.currentQuestion : prevState.currentQuestion + 1;
                return {
                    ...prevState,
                    currentQuestion,
                    selectedAnswers,
                    showNextButton,
                };
            });
        };

        const handleNextClick = () => {
            setState(prevState => {
                const firstUnanswered = prevState.selectedAnswers.findIndex(answer => answer === null);
                const currentQuestion = firstUnanswered !== -1 ? firstUnanswered : prevState.currentQuestion + 1;
                const showScore = currentQuestion === questions.length;
                return {
                    ...prevState,
                    currentQuestion,
                    showScore,
                };
            });
        };

        const handleQuestionNavigation = (questionIndex) => {
            setState(prevState => ({
                ...prevState,
                currentQuestion: questionIndex,
            }));
        };

        const handleStartClick = () => {
            setState(prevState => ({
                ...prevState,
                quizStarted: true,
            }));
        };

        const handleRestartClick = () => {
            setState({
                currentQuestion: 0,
                selectedAnswers: Array(questions.length).fill(null),
                quizStarted: false,
                showScore: false,
            });
        };

        return {handleAnswerSelect, handleNextClick, handleQuestionNavigation, handleStartClick, handleRestartClick};
    }, [questions]);

    const renderQuestion = useMemo(() => {
        const {currentQuestion, selectedAnswers, showScore} = state;
        if (questions.length === 0) {
            return <div>Loading...</div>;
        }
        const question = questions[currentQuestion];
        const isLastQuestion = currentQuestion === questions.length - 1;
        const showNextButton = selectedAnswers[currentQuestion] !== null || showScore;
        if (showScore) {
            const correctAnswers = state.selectedAnswers.filter(
                (answer, index) => answer === +questions[index].jsonQuestion.correctAnswer
            ).length;
            const score = `${correctAnswers} out of ${questions.length}`;
            return (
                <div className="Quiz container text-center">
                    <h2>Quiz Results</h2>
                    <p>You answered {score} questions correctly.</p>
                    <button onClick={handleRestartClick} className="start-button btn btn-warning">
                        Start Over
                    </button>
                </div>
            );
        } else {
            return (
                <>
                    <div className="question-navigation w-100">
                        {questions.map((_, index) => {
                            const isSelected = currentQuestion === index;
                            const isAnswered = selectedAnswers[index] !== null;
                            const isCorrect = isAnswered && +questions[index].jsonQuestion.correctAnswer === selectedAnswers[index];
                            return (
                                <button
                                    key={index}
                                    onClick={() => handleQuestionNavigation(index)}
                                    className={isSelected ? "current nav-question-button" : "nav-question-button"}
                                    style={{
                                        backgroundColor:
                                            selectedAnswers[index] !== null ? (isCorrect ? 'green' : 'red') : '',
                                    }}
                                >
                                    {index + 1}
                                </button>
                            );
                        })}
                    </div>
                    <div className={"col-sm-12 question-text"}>
                        <h2 className={"font-6"}>{question.jsonQuestion.text}</h2>
                    </div>
                    <div className={"row reverse g-5"}>
                        <ul className={"list-unstyled col-lg-7"}>
                            {question.jsonQuestion.answers.map((answer, index) => {
                                const isSelected = selectedAnswers[currentQuestion] === index;
                                const isCorrect = +question.jsonQuestion.correctAnswer === index; // попробувати з parseInt()
                                const showCorrect = showNextButton && isCorrect;
                                const className = AnswerButton.getClassName(isSelected, isCorrect, showCorrect);
                                return (
                                    <li key={index} className={"list-unstyled"}>
                                        <AnswerButton
                                            answer={answer}
                                            className={className}
                                            disabled={showNextButton}
                                            onClick={() => handleAnswerSelect(index)}
                                        />
                                    </li>
                                );
                            })
                            }
                        </ul>
                            <div className={"col-lg-5 col-lg question-photo"}>
                                <img className={"w-100 h-100"} src={"/quizPhotos/"+question.jsonQuestion.photo}
                                     style={{"borderRadius": "16px"}} alt={"Запитання фотографії немає."}/>
                            </div>
                    </div>
                    {showNextButton && (
                        <button onClick={handleNextClick} className="next-button btn btn-warning">
                            {isLastQuestion ? 'Check Unanswered' : 'Next'}
                        </button>
                    )}
                </>
            );
        }
    }, [state, handleAnswerSelect, handleRestartClick, questions, handleNextClick, handleQuestionNavigation]);

    useEffect(() => {
        if (state.selectedAnswers.every(answer => answer !== null)) {
            setState(prevState => ({
                ...prevState,
                showScore: false,
            }));
        }
    }, [state.selectedAnswers]);

    return (
        <div className="Quiz container text-center">
            {!state.quizStarted ? (
                <button onClick={handleStartClick} className="btn start-button py-3 px-5">
                    Start
                </button>
            ) : (
                renderQuestion
            )}
        </div>
    );
};

export default Quiz;