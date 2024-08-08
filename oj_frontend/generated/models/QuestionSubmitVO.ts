/* generated using openapi-typescript-codegen -- do not edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { JudgeInfo } from "./JudgeInfo";
import type { QuestionVO } from "./QuestionVO";
import type { UserVO } from "./UserVO";

export type QuestionSubmitVO = {
  id?: number;
  language?: string;
  code?: string;
  status?: number;
  judgeInfo?: JudgeInfo;
  questionId?: number;
  userId?: number;
  userVO?: UserVO;
  questionVO?: QuestionVO;
};

